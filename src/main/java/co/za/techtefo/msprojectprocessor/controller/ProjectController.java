package co.za.techtefo.msprojectprocessor.controller;
import co.za.techtefo.msprojectprocessor.model.ProjectData;
import co.za.techtefo.msprojectprocessor.model.ProjectStatus;
import co.za.techtefo.msprojectprocessor.model.Task;
import co.za.techtefo.msprojectprocessor.model.YesNo;
import co.za.techtefo.msprojectprocessor.service.ERPNextService;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.reader.UniversalProjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

@RestController
public class ProjectController {
    private ERPNextService erpNextService;
    private ProjectData project;

    @Autowired
    public ProjectController(ERPNextService erpNextService) {
        this.erpNextService = erpNextService;
    }

    @PostMapping("/Upload")
    public String processFile(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        InputStream stream = file.getInputStream();
        var reader = new UniversalProjectReader();
        try {
            ProjectFile projectFile =  reader.readAll(stream).get(0);
            net.sf.mpxj.Task projectTask = projectFile.getChildTasks().get(0);
            String projectName = projectTask.getName();
            project = getProjectDataByProjectName(projectName);
            if(project == null) {
                createProjectIfNotExist(projectName);
            }
            net.sf.mpxj.Task rootTask = projectTask.getChildTasks().get(0);
            processTaskHierarchy(rootTask, null);// is the parent null or is the root task?
        } catch (MPXJException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    Hashtable<String,Task> taskCache = new Hashtable<>();
    private void processTaskHierarchy(net.sf.mpxj.Task task, net.sf.mpxj.Task parentTask) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // If task ID is 0, it's the root task representing the project. Check and create the project if it doesn't exist.
//        if (task.getID() == 0) {
//            createProjectIfNotExist(projectName);
//            // Process child tasks for the project
//            for (var childTask : task.getChildTasks()) {
//                processTaskHierarchy(childTask, project.getName(), null);
//            }
//            return;
//        }

        // For non-root tasks, process them as individual tasks
        String taskName = task.getName();
        Task erpNextTask = new Task(taskName,project.getName());
        var startDate = task.getStart() != null?dateFormat.format(task.getStart()):"";
        var endDate = task.getFinish() != null ? dateFormat.format(task.getFinish()):"";


        erpNextTask.setProject(project.getName());
        erpNextTask.setExpectedStartDate(startDate);
        erpNextTask.setExpectedEndDate(endDate);

        // If the parentTask is provided, fetch its details from ERPNext and set the current task's dependency
        if (parentTask != null) {
            if(!taskCache.containsKey(parentTask.getName())) {
                Task parentTaskInERPNext = this.erpNextService.getTaskByNameAndProject(parentTask.getName(), project.getName());
                taskCache.put(parentTask.getName(),parentTaskInERPNext);
            }
//            String taskSubject = taskCache.get(parentTask.getName());
            if(!parentTask.getName().equalsIgnoreCase(task.getParentTask().getName())){
                throw new RuntimeException("Task's parent is not the same as provided parent task: Task Parent: " +task.getParentTask().getName()+" Provided Parent: "+parentTask.getName());
            }
            erpNextTask.setDependsOnTasks(parentTask.getName());
        }

        // Create the task in ERPNext and retrieve its unique identifier

        Task serverRecord = this.erpNextService.getTaskByNameAndProject(taskName, project.getName());
        if(serverRecord!=null)taskCache.put(taskName,serverRecord);

        if(serverRecord == null){
            Task createdTask = this.erpNextService.createTask(erpNextTask);
            if (createdTask == null) {
                throw new RuntimeException("Failed to create task in ERPNext: " + erpNextTask.getSubject());
            }
            taskCache.put(taskName,createdTask);
        }

        for (net.sf.mpxj.Task childTask : task.getChildTasks()) {
            processTaskHierarchy(childTask, task);
        }
    }
    private void createProjectIfNotExist(String projectName) {
        ProjectData existingProject = getProjectDataByProjectName(projectName);
        if(existingProject == null){
            var projectEntity = new ProjectData(projectName);
            projectEntity.setIsActive(YesNo.Yes);
            projectEntity.setStatus(ProjectStatus.Open);
            ProjectData createdProject = this.erpNextService.createProject(projectEntity);
            this.project = createdProject;
            cache.put(projectName,createdProject);
        }
    }

    Hashtable<String,ProjectData> cache = new Hashtable<>();
    private ProjectData getProjectDataByProjectName(String projectName) {

        if(cache.containsKey(projectName))return  cache.get(projectName);
        ProjectData project = this.erpNextService.getProjectByName(projectName);
        if(project !=null) cache.put(projectName,project);
        return project;
    }
}

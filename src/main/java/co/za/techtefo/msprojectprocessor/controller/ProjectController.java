package co.za.techtefo.msprojectprocessor.controller;

import co.za.techtefo.msprojectprocessor.model.*;
import co.za.techtefo.msprojectprocessor.service.ERPNextService;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Relation;
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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
            ProjectFile projectFile = reader.readAll(stream).get(0);
            net.sf.mpxj.Task projectTask = projectFile.getChildTasks().get(0);
            String projectName = projectTask.getName();
            project = getProjectDataByProjectName(projectName);
            if (project == null) {
                createProjectIfNotExist(projectName);
            }
            net.sf.mpxj.Task rootTask = projectTask.getChildTasks().get(0);
            processTaskHierarchy(rootTask);// is the parent null or is the root task?
        } catch (MPXJException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    Hashtable<String, Task> taskCache = new Hashtable<>();

    private void processTaskHierarchy(net.sf.mpxj.Task task) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String taskName = task.getID() +" "+ task.getName();
        taskName = taskName.replace("(", "");
        taskName = taskName.replace(")","");
        Task erpNextTask = new Task(taskName, project.getName());
        if(task.getSummary()){
            erpNextTask.setIsGroup(1);
        }
        var startDate = task.getStart() != null ? dateFormat.format(task.getStart()) : "";
        var endDate = task.getFinish() != null ? dateFormat.format(task.getFinish()) : "";

        List<Relation> ancestors = task.getPredecessors();
        List<Task> dependencies = ancestors.stream().map(ancestor ->
                new Task(ancestor.getTargetTask().getID()+" "+ancestor.getTargetTask().getName().replace("(", "").replace(")",""))
        ).toList();

        dependencies.forEach((Task t) -> {
            Task serverRecord = this.erpNextService.getTaskByNameAndProject(t.getSubject(), this.project.getName());
            if (serverRecord != null) {
                t.setName(serverRecord.getName());
            }
        });

        List<TaskDependsOn> dependentTasks = dependencies.stream().map(t ->
                new TaskDependsOn(t.getName())
        ).toList();

        erpNextTask.setProject(project.getName());
        erpNextTask.setExpectedStartDate(startDate);
        erpNextTask.setExpectedEndDate(endDate);
        erpNextTask.setDepends_on(dependentTasks);

//        Task createdTask = this.erpNextService.createTask(erpNextTask);
//        if (createdTask == null) {
//            throw new RuntimeException("Failed to create task in ERPNext: " + erpNextTask.getSubject());
//        }
//        taskCache.put(taskName, createdTask);

        Task serverRecord = this.erpNextService.getTaskByNameAndProject(taskName, project.getName());
        if (serverRecord != null) {
            taskCache.put(taskName, serverRecord);
            serverRecord.setProject(project.getName());
            serverRecord.setExpectedStartDate(startDate);
            serverRecord.setExpectedEndDate(endDate);
            serverRecord.setDepends_on(dependentTasks);
            this.erpNextService.updateTask(serverRecord);
            //update the task
        } else {
            Task createdTask = this.erpNextService.createTask(erpNextTask);
            if (createdTask == null) {
                throw new RuntimeException("Failed to create task in ERPNext: " + erpNextTask.getSubject());
            }
            taskCache.put(taskName, createdTask);
        }

        for (net.sf.mpxj.Task childTask : task.getChildTasks()) {
            processTaskHierarchy(childTask);
        }
    }

    private void createProjectIfNotExist(String projectName) {
        ProjectData existingProject = getProjectDataByProjectName(projectName);
        if (existingProject == null) {
            var projectEntity = new ProjectData(projectName);
            projectEntity.setIsActive(YesNo.Yes);
            projectEntity.setStatus(ProjectStatus.Open);
            ProjectData createdProject = this.erpNextService.createProject(projectEntity);
            this.project = createdProject;
            cache.put(projectName, createdProject);
        }
    }

    Hashtable<String, ProjectData> cache = new Hashtable<>();

    private ProjectData getProjectDataByProjectName(String projectName) {

        if (cache.containsKey(projectName)) return cache.get(projectName);
        ProjectData project = this.erpNextService.getProjectByName(projectName);
        if (project != null) cache.put(projectName, project);
        return project;
    }
}

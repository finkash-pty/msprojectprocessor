package co.za.techtefo.msprojectprocessor.service;

import co.za.techtefo.msprojectprocessor.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


@Service
public class ERPNextService {
    @Value("${erpnext.base-url}")
    private String erpnextBaseUrl;
    @Value("${erpnext.api-key}")
    private String apiKey;
    @Value("${erpnext.api-secret}")
    private String apiSecret;

    public List<ProjectInfo> searchProjectsByName(String projectName) {
        String url = erpnextBaseUrl + "/api/resource/Project?fields=[\"project_name\",\"name\"]&filters=[[\"Project\",\"project_name\",\"like\",\"%" + projectName + "%\"]]";

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProjectListResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, ProjectListResponse.class);

        List<ProjectData> projects = response.getBody().getData();

        List<ProjectInfo> projectInfoList = new ArrayList<>();
        for (ProjectData project : projects) {
            ProjectInfo projectInfo = new ProjectInfo(project.getProjectName(), project.getName());
            projectInfoList.add(projectInfo);
        }

        return projectInfoList;
    }

    public ProjectData createProject(ProjectData project){
        String url = erpnextBaseUrl+"/api/resource/Project";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","token "+apiKey+":"+ apiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectData> requestEntity = new HttpEntity<>(project,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProjectData> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,ProjectData.class);

        return response.getBody();
    }

    public ProjectData getProjectByName(String projectName) {
        String url = erpnextBaseUrl + "/api/resource/Project?fields=[\"*\"]&filters=[[\"Project\",\"project_name\",\"=\",\"" + projectName + "\"]]";

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProjectListResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, ProjectListResponse.class);

        List<ProjectData> projectDataList = response.getBody().getData();

        if (projectDataList != null && !projectDataList.isEmpty()) {
            return projectDataList.get(0);
        } else {
            return null; // Project with the given name not found
        }
    }

    public List<Task> getTasksByProjectName(String taskName, String projectName) {
        // Manually building the URL
        String encodedProjectName = URLEncoder.encode(projectName, StandardCharsets.UTF_8);
        String encodedTaskName = URLEncoder.encode(taskName, StandardCharsets.UTF_8);
        String filtersValue = String.format("[[\"project\",\"=\",\"%s\"],[\"subject\",\"=\",\"%s\"]]", encodedProjectName, encodedTaskName);
        String fieldsValue = "[\"*\"]";

        String originUrl = erpnextBaseUrl + "/api/resource/Task?filters=" + filtersValue + "&fields=" + fieldsValue;
        String url = StringUtils.replaceEach(originUrl,
        new String[]{"%28","%29"},
                new String[]{"(",")"});

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TaskListReponse> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<TaskListReponse>() {});

        return response.getBody().getData();
    }


//    public List<Task> getTasksByProjectName(String taskName, String projectName) {
//        String filtersValue = String.format("[[\"project\", \"=\", \"%s\"], [\"subject\", \"=\", \"%s\"]]", projectName, taskName);
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(erpnextBaseUrl)
//                .path("/api/resource/Task")
//                .queryParam("filters", filtersValue)
//                .queryParam("fields", "[\"*\"]");
//
//        String constructedUri = builder.toUriString();
//        String url = postProcessUri(constructedUri);
//
//        HttpHeaders headers = new HttpHeaders();
//        String authHeader = "token " + apiKey + ":" + apiSecret;
//        headers.set("Authorization", authHeader);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<TaskListReponse> response = restTemplate.exchange(
//                url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<TaskListReponse>() {});
//        return response.getBody().getData();
//    }



    private String postProcessUri(String uri) {
        // Decode specific characters: %5B as [, %5D as ], %28 as (, and %29 as )
        return uri.replace("%5B", "[")
                .replace("%5D", "]")
                .replace("%28", "(")
                .replace("%29", ")");
    }




    public Task getTaskByNameAndProject(String taskName, String projectName) {
        List<Task> tasks = getTasksByProjectName(taskName,projectName);
        for (Task task : tasks) {
            if (task.getSubject().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    public String updateProject(ProjectData project) {
        String url = erpnextBaseUrl + "/api/resource/Project/" + project.getName();

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectData> requestEntity = new HttpEntity<>(project, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, String.class);

        return response.getBody();
    }

    public String deleteProject(String projectId) {
        String url = erpnextBaseUrl + "/api/resource/Project/" + projectId;

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.DELETE, requestEntity, String.class);

        return response.getBody();
    }

    public Task createTask(Task task) {
        String url = erpnextBaseUrl + "/api/resource/Task";

        HttpHeaders headers = new HttpHeaders();
        String authHeader = "token " + apiKey + ":" + apiSecret;
        headers.set("Authorization", authHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Task> requestEntity = new HttpEntity<>(task, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TaskResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, TaskResponse.class);
        return response.getBody().getData();
    }


}

package co.za.techtefo.msprojectprocessor.model;

public class ProjectInfo {
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String project_name;
    private String name;

    public ProjectInfo(String project_name, String name) {
        this.project_name = project_name;
        this.name = name;
    }
}

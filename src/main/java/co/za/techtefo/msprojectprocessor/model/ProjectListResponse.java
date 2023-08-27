package co.za.techtefo.msprojectprocessor.model;

import java.util.List;

public class ProjectListResponse {
    private List<ProjectData> data;

    public List<ProjectData> getData() {
        return data;
    }

    public void setData(List<ProjectData> data) {
        this.data = data;
    }
}

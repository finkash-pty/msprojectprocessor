package co.za.techtefo.msprojectprocessor.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    @JsonProperty("name")
    private String name;

    @JsonProperty("creation")
    private String creation;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("docstatus")
    private Integer docStatus;

    @JsonProperty("idx")
    private Integer idx;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("project")
    private String project;

    @JsonProperty("issue")
    private String issue;

    @JsonProperty("type")
    private String type;

    @JsonProperty("color")
    private String color;

    @JsonProperty("is_group")
    private Integer isGroup;

    @JsonProperty("is_template")
    private Integer isTemplate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("task_weight")
    private Double taskWeight;

    @JsonProperty("parent_task")
    private String parentTask;

    @JsonProperty("completed_by")
    private String completedBy;

    @JsonProperty("completed_on")
    private String completedOn;

    @JsonProperty("exp_start_date")
    private String expectedStartDate;

    @JsonProperty("expected_time")
    private Double expectedTime;

    @JsonProperty("start")
    private Integer start;

    @JsonProperty("exp_end_date")
    private String expectedEndDate;

    @JsonProperty("progress")
    private Double progress;

    @JsonProperty("duration")
    private Integer duration;

    @JsonProperty("is_milestone")
    private Integer isMilestone;

    @JsonProperty("description")
    private String description;

    @JsonProperty("depends_on_tasks")
    private String dependsOnTasks;

    @JsonProperty("act_start_date")
    private String actualStartDate;

    @JsonProperty("actual_time")
    private Double actualTime;

    @JsonProperty("act_end_date")
    private String actualEndDate;

    @JsonProperty("total_costing_amount")
    private Double totalCostingAmount;

    @JsonProperty("total_billing_amount")
    private Double totalBillingAmount;

    @JsonProperty("review_date")
    private String reviewDate;

    @JsonProperty("closing_date")
    private String closingDate;

    @JsonProperty("department")
    private String department;

    @JsonProperty("company")
    private String company;

    @JsonProperty("lft")
    private Integer lft;

    @JsonProperty("rgt")
    private Integer rgt;

    @JsonProperty("old_parent")
    private String oldParent;

    @JsonProperty("_user_tags")
    private String userTags;

    @JsonProperty("_comments")
    private String comments;

    @JsonProperty("_assign")
    private String assign;

    @JsonProperty("_liked_by")
    private String likedBy;

    @JsonProperty("_seen")
    private String seen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(Integer docStatus) {
        this.docStatus = docStatus;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getTaskWeight() {
        return taskWeight;
    }

    public void setTaskWeight(Double taskWeight) {
        this.taskWeight = taskWeight;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
    }

    public String getExpectedStartDate() {
        return expectedStartDate;
    }

    public void setExpectedStartDate(String expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }

    public Double getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Double expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setExpectedEndDate(String expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getIsMilestone() {
        return isMilestone;
    }

    public void setIsMilestone(Integer isMilestone) {
        this.isMilestone = isMilestone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDependsOnTasks() {
        return dependsOnTasks;
    }

    public void setDependsOnTasks(String dependsOnTasks) {
        this.dependsOnTasks = dependsOnTasks;
    }

    public String getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(String actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Double getActualTime() {
        return actualTime;
    }

    public void setActualTime(Double actualTime) {
        this.actualTime = actualTime;
    }

    public String getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Double getTotalCostingAmount() {
        return totalCostingAmount;
    }

    public void setTotalCostingAmount(Double totalCostingAmount) {
        this.totalCostingAmount = totalCostingAmount;
    }

    public Double getTotalBillingAmount() {
        return totalBillingAmount;
    }

    public void setTotalBillingAmount(Double totalBillingAmount) {
        this.totalBillingAmount = totalBillingAmount;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public String getOldParent() {
        return oldParent;
    }

    public void setOldParent(String oldParent) {
        this.oldParent = oldParent;
    }

    public String getUserTags() {
        return userTags;
    }

    public void setUserTags(String userTags) {
        this.userTags = userTags;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(String likedBy) {
        this.likedBy = likedBy;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    public Task(String name, String creation, String modified, String modifiedBy, String owner, Integer docStatus, Integer idx, String subject, String project, String issue, String type, String color, Integer isGroup, Integer isTemplate, String status, String priority, Double taskWeight, String parentTask, String completedBy, String completedOn, String expectedStartDate, Double expectedTime, Integer start, String expectedEndDate, Double progress, Integer duration, Integer isMilestone, String description, String dependsOnTasks, String actualStartDate, Double actualTime, String actualEndDate, Double totalCostingAmount, Double totalBillingAmount, String reviewDate, String closingDate, String department, String company, Integer lft, Integer rgt, String oldParent, String userTags, String comments, String assign, String likedBy, String seen) {
        this.name = name;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.owner = owner;
        this.docStatus = docStatus;
        this.idx = idx;
        this.subject = subject;
        this.project = project;
        this.issue = issue;
        this.type = type;
        this.color = color;
        this.isGroup = isGroup;
        this.isTemplate = isTemplate;
        this.status = status;
        this.priority = priority;
        this.taskWeight = taskWeight;
        this.parentTask = parentTask;
        this.completedBy = completedBy;
        this.completedOn = completedOn;
        this.expectedStartDate = expectedStartDate;
        this.expectedTime = expectedTime;
        this.start = start;
        this.expectedEndDate = expectedEndDate;
        this.progress = progress;
        this.duration = duration;
        this.isMilestone = isMilestone;
        this.description = description;
        this.dependsOnTasks = dependsOnTasks;
        this.actualStartDate = actualStartDate;
        this.actualTime = actualTime;
        this.actualEndDate = actualEndDate;
        this.totalCostingAmount = totalCostingAmount;
        this.totalBillingAmount = totalBillingAmount;
        this.reviewDate = reviewDate;
        this.closingDate = closingDate;
        this.department = department;
        this.company = company;
        this.lft = lft;
        this.rgt = rgt;
        this.oldParent = oldParent;
        this.userTags = userTags;
        this.comments = comments;
        this.assign = assign;
        this.likedBy = likedBy;
        this.seen = seen;
    }

    public Task() {
    }

    public Task(String subject, String project) {
        this.subject = subject;
        this.project = project;
    }
}

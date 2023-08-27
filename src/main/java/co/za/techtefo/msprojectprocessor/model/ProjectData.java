package co.za.techtefo.msprojectprocessor.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectData {
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

    @JsonProperty("naming_series")
    private String namingSeries;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("status")
    private ProjectStatus status;

    @JsonProperty("project_type")
    private String projectType;

    @JsonProperty("is_active")
    private YesNo isActive;

    @JsonProperty("percent_complete_method")
    private String percentCompleteMethod;

    @JsonProperty("percent_complete")
    private Double percentComplete;

    @JsonProperty("project_template")
    private String projectTemplate;

    @JsonProperty("expected_start_date")
    private String expectedStartDate;

    @JsonProperty("expected_end_date")
    private String expectedEndDate;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("department")
    private String department;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("sales_order")
    private String salesOrder;

    @JsonProperty("copied_from")
    private String copiedFrom;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("actual_start_date")
    private String actualStartDate;

    @JsonProperty("actual_time")
    private Double actualTime;

    @JsonProperty("actual_end_date")
    private String actualEndDate;

    @JsonProperty("estimated_costing")
    private Double estimatedCosting;

    @JsonProperty("total_costing_amount")
    private Double totalCostingAmount;

    @JsonProperty("total_purchase_cost")
    private Double totalPurchaseCost;

    @JsonProperty("company")
    private String company;

    @JsonProperty("total_sales_amount")
    private Double totalSalesAmount;

    @JsonProperty("total_billable_amount")
    private Double totalBillableAmount;

    @JsonProperty("total_billed_amount")
    private Double totalBilledAmount;

    @JsonProperty("total_consumed_material_cost")
    private Double totalConsumedMaterialCost;

    @JsonProperty("cost_center")
    private String costCenter;

    @JsonProperty("gross_margin")
    private Double grossMargin;

    @JsonProperty("per_gross_margin")
    private Double perGrossMargin;

    @JsonProperty("collect_progress")
    private Integer collectProgress;

    @JsonProperty("holiday_list")
    private String holidayList;

    @JsonProperty("frequency")
    private String frequency;

    @JsonProperty("from_time")
    private String fromTime;

    @JsonProperty("to_time")
    private String toTime;

    @JsonProperty("first_email")
    private String firstEmail;

    @JsonProperty("second_email")
    private String secondEmail;

    @JsonProperty("daily_time_to_send")
    private String dailyTimeToSend;

    @JsonProperty("day_to_send")
    private String dayToSend;

    @JsonProperty("weekly_time_to_send")
    private String weeklyTimeToSend;

    @JsonProperty("message")
    private String message;

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

    // Constructors

    public ProjectData() {
        // Default constructor
    }

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

    public String getNamingSeries() {
        return namingSeries;
    }

    public void setNamingSeries(String namingSeries) {
        this.namingSeries = namingSeries;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public YesNo getIsActive() {
        return isActive;
    }

    public void setIsActive(YesNo isActive) {
        this.isActive = isActive;
    }

    public String getPercentCompleteMethod() {
        return percentCompleteMethod;
    }

    public void setPercentCompleteMethod(String percentCompleteMethod) {
        this.percentCompleteMethod = percentCompleteMethod;
    }

    public Double getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(Double percentComplete) {
        this.percentComplete = percentComplete;
    }

    public String getProjectTemplate() {
        return projectTemplate;
    }

    public void setProjectTemplate(String projectTemplate) {
        this.projectTemplate = projectTemplate;
    }

    public String getExpectedStartDate() {
        return expectedStartDate;
    }

    public void setExpectedStartDate(String expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }

    public String getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setExpectedEndDate(String expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getCopiedFrom() {
        return copiedFrom;
    }

    public void setCopiedFrom(String copiedFrom) {
        this.copiedFrom = copiedFrom;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Double getEstimatedCosting() {
        return estimatedCosting;
    }

    public void setEstimatedCosting(Double estimatedCosting) {
        this.estimatedCosting = estimatedCosting;
    }

    public Double getTotalCostingAmount() {
        return totalCostingAmount;
    }

    public void setTotalCostingAmount(Double totalCostingAmount) {
        this.totalCostingAmount = totalCostingAmount;
    }

    public Double getTotalPurchaseCost() {
        return totalPurchaseCost;
    }

    public void setTotalPurchaseCost(Double totalPurchaseCost) {
        this.totalPurchaseCost = totalPurchaseCost;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(Double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public Double getTotalBillableAmount() {
        return totalBillableAmount;
    }

    public void setTotalBillableAmount(Double totalBillableAmount) {
        this.totalBillableAmount = totalBillableAmount;
    }

    public Double getTotalBilledAmount() {
        return totalBilledAmount;
    }

    public void setTotalBilledAmount(Double totalBilledAmount) {
        this.totalBilledAmount = totalBilledAmount;
    }

    public Double getTotalConsumedMaterialCost() {
        return totalConsumedMaterialCost;
    }

    public void setTotalConsumedMaterialCost(Double totalConsumedMaterialCost) {
        this.totalConsumedMaterialCost = totalConsumedMaterialCost;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public Double getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(Double grossMargin) {
        this.grossMargin = grossMargin;
    }

    public Double getPerGrossMargin() {
        return perGrossMargin;
    }

    public void setPerGrossMargin(Double perGrossMargin) {
        this.perGrossMargin = perGrossMargin;
    }

    public Integer getCollectProgress() {
        return collectProgress;
    }

    public void setCollectProgress(Integer collectProgress) {
        this.collectProgress = collectProgress;
    }

    public String getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(String holidayList) {
        this.holidayList = holidayList;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public void setFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }

    public String getDailyTimeToSend() {
        return dailyTimeToSend;
    }

    public void setDailyTimeToSend(String dailyTimeToSend) {
        this.dailyTimeToSend = dailyTimeToSend;
    }

    public String getDayToSend() {
        return dayToSend;
    }

    public void setDayToSend(String dayToSend) {
        this.dayToSend = dayToSend;
    }

    public String getWeeklyTimeToSend() {
        return weeklyTimeToSend;
    }

    public void setWeeklyTimeToSend(String weeklyTimeToSend) {
        this.weeklyTimeToSend = weeklyTimeToSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public ProjectData(String projectName){
        this.projectName = projectName;
    }

    // Constructor with all fields
    public ProjectData(String name, String creation, String modified, String modifiedBy, String owner,
                       Integer docStatus, Integer idx, String namingSeries, String projectName, ProjectStatus status,
                       String projectType, YesNo isActive, String percentCompleteMethod, Double percentComplete,
                       String projectTemplate, String expectedStartDate, String expectedEndDate, String priority,
                       String department, String customer, String salesOrder, String copiedFrom, String notes,
                       String actualStartDate, Double actualTime, String actualEndDate, Double estimatedCosting,
                       Double totalCostingAmount, Double totalPurchaseCost, String company, Double totalSalesAmount,
                       Double totalBillableAmount, Double totalBilledAmount, Double totalConsumedMaterialCost,
                       String costCenter, Double grossMargin, Double perGrossMargin, Integer collectProgress,
                       String holidayList, String frequency, String fromTime, String toTime, String firstEmail,
                       String secondEmail, String dailyTimeToSend, String dayToSend, String weeklyTimeToSend,
                       String message, String userTags, String comments, String assign, String likedBy, String seen) {
        this.name = name;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.owner = owner;
        this.docStatus = docStatus;
        this.idx = idx;
        this.namingSeries = namingSeries;
        this.projectName = projectName;
        this.status = status;
        this.projectType = projectType;
        this.isActive = isActive;
        this.percentCompleteMethod = percentCompleteMethod;
        this.percentComplete = percentComplete;
        this.projectTemplate = projectTemplate;
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.priority = priority;
        this.department = department;
        this.customer = customer;
        this.salesOrder = salesOrder;
        this.copiedFrom = copiedFrom;
        this.notes = notes;
        this.actualStartDate = actualStartDate;
        this.actualTime = actualTime;
        this.actualEndDate = actualEndDate;
        this.estimatedCosting = estimatedCosting;
        this.totalCostingAmount = totalCostingAmount;
        this.totalPurchaseCost = totalPurchaseCost;
        this.company = company;
        this.totalSalesAmount = totalSalesAmount;
        this.totalBillableAmount = totalBillableAmount;
        this.totalBilledAmount = totalBilledAmount;
        this.totalConsumedMaterialCost = totalConsumedMaterialCost;
        this.costCenter = costCenter;
        this.grossMargin = grossMargin;
        this.perGrossMargin = perGrossMargin;
        this.collectProgress = collectProgress;
        this.holidayList = holidayList;
        this.frequency = frequency;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.dailyTimeToSend = dailyTimeToSend;
        this.dayToSend = dayToSend;
        this.weeklyTimeToSend = weeklyTimeToSend;
        this.message = message;
        this.userTags = userTags;
        this.comments = comments;
        this.assign = assign;
        this.likedBy = likedBy;
        this.seen = seen;
    }

    // Getters and Setters
    // ...

    // toString() method
    @Override
    public String toString() {
        return "ProjectData{" +
                "name='" + name + '\'' +
                ", creation='" + creation + '\'' +
                ", modified='" + modified + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                // ... Include other fields ...
                '}';
    }
}

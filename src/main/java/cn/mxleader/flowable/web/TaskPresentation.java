package cn.mxleader.flowable.web;

import java.util.Date;

public class TaskPresentation {
    private String id;
    private String processInstanceId;
    private String executionId;
    private String name;
    private Date createTime;
    private String taskDefinitionKey;

    public TaskPresentation(String id, String processInstanceId, String executionId,
                            String name, Date createTime, String taskDefinitionKey) {
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.executionId = executionId;
        this.name = name;
        this.createTime = createTime;
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }
}

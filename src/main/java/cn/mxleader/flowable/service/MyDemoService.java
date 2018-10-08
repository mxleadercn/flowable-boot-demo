package cn.mxleader.flowable.service;

import cn.mxleader.flowable.process.CustomEventListener;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyDemoService {

    private final RepositoryService repositoryService;

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    MyDemoService(RepositoryService repositoryService, RuntimeService runtimeService, TaskService taskService) {
        this.repositoryService = repositoryService;
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        repositoryService.createDeployment()
                .addClasspathResource("processes/basic.bpmn20.xml")
                .addClasspathResource("processes/holiday-request.bpmn20.xml").deploy();
    }

    public ProcessInstance startProcess(String processKey, Map<String, Object> variables) {
        runtimeService.addEventListener(new CustomEventListener());
        return runtimeService.startProcessInstanceByKey(processKey, variables);
    }

    public List<Task> getGroupTasks(String groupName) {
        return taskService.createTaskQuery().taskCandidateGroup(groupName).list();
    }

    public void completeTask(Task task){
        Map<String, Object> variables = new HashMap<>();
        variables.put("approved", true);
        taskService.complete(task.getId(), variables);
    }

    public void roobackTask(Task task){
        /*Map<String, Object> variables = new HashMap<>();
        variables.put("approved", true);
        runtimeService.createChangeActivityStateBuilder().processInstanceId(task.getProcessInstanceId()).cancelActivityId(task.getId()).startActivityId(task.get).changeState();
*/
    }

}

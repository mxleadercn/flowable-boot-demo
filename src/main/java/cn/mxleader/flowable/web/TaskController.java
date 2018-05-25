package cn.mxleader.flowable.web;

import cn.mxleader.flowable.service.MyDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TaskController {

    @Autowired
    private MyDemoService myDemoService;

    @RequestMapping("/tasks")
    public Flux<TaskPresentation> getManagerTasks() {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(500));
        Flux<TaskPresentation> events = Flux.fromStream(
                myDemoService.getGroupTasks("managers").stream()
                        .map(task -> new TaskPresentation(task.getId(),
                                task.getProcessInstanceId(),
                                task.getExecutionId(),
                                task.getName(),
                                task.getCreateTime(),
                                task.getTaskDefinitionKey())));
        return Flux.zip(interval, events).map(Tuple2::getT2);
    }

    @PostMapping("/start")
    public String startProcess() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", "Michael Chen");
        variables.put("nrOfHolidays", 9);
        variables.put("description", "I want to enjoy holiday..........");
        myDemoService.startProcess("holidayRequest", variables);
        return "OK";
    }

    @PostMapping("/complete/{taskIndex}")
    public String completeTask(@PathVariable Integer taskIndex) {
        myDemoService.completeTask(myDemoService.getGroupTasks("managers").get(taskIndex));
        return "OK";
    }
}

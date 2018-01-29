package cn.mxleader.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class DelegateServiceTask implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        System.out.println("执行 JavaDelegate 代理任务, customerId = "
                + execution.getVariable("customerId"));
    }

}

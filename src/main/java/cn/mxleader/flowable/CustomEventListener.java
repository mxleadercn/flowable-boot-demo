package cn.mxleader.flowable;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;

public class CustomEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
        switch ((FlowableEngineEventType) event.getType()) {

            case JOB_EXECUTION_SUCCESS:
                System.out.println("JOB成功执行!");
                break;
            case JOB_EXECUTION_FAILURE:
                System.out.println("JOB执行失败...");
                break;
            case TASK_COMPLETED:
                System.out.println("事件监听器标记：任务完成");
            case TASK_CREATED:
                System.out.println("事件监听器标记：创建新任务");
            case TASK_ASSIGNED:
                System.out.println("事件监听器标记：任务已分配");
            case PROCESS_CREATED:
                System.out.println("事件监听器标记：创建新流程");
            case PROCESS_COMPLETED:
                System.out.println("事件监听器标记：流程已结束");
            default:
                System.out.println("监听事件类型：" + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}

package cn.mxleader.flowable.process;

import org.springframework.stereotype.Component;

@Component("customService")
public class CustomService {

    public void storeResume() {
        System.out.println("正在启动流程，请稍后...");
    }
}

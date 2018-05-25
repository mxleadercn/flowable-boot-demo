package cn.mxleader.flowable;

import cn.mxleader.flowable.service.MyDemoService;
import org.flowable.common.engine.impl.persistence.StrongUuidGenerator;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.db.DbIdGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FlowableDemoApplication {
/*
	@Bean
	public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> processEngineDbIdGeneratorConfigurer() {
		//return engineConfiguration -> engineConfiguration.setIdGenerator(new StrongUuidGenerator());
		return engineConfiguration -> engineConfiguration.setIdGenerator(new DbIdGenerator());
	}
	*/
	@Bean
	CommandLineRunner basics(final RuntimeService runtimeService) {
		return args->runtimeService.startProcessInstanceByKey("waiter",
				Collections.singletonMap("customerId", 243L));
	}

	@Bean
	CommandLineRunner startProcessInstance(final MyDemoService myDemoService) {
		return args-> {

			Map<String, Object> variables = new HashMap<>();
			variables.put("employee", "Michael Chen");
			variables.put("nrOfHolidays", 9);
			variables.put("description", "I want to enjoy holiday..........");
			myDemoService.startProcess("holidayRequest",variables);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FlowableDemoApplication.class, args);
	}
}

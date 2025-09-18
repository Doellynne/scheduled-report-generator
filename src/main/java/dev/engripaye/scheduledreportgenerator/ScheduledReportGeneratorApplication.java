package dev.engripaye.scheduledreportgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // spring scheduling support
public class ScheduledReportGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledReportGeneratorApplication.class, args);
	}

}

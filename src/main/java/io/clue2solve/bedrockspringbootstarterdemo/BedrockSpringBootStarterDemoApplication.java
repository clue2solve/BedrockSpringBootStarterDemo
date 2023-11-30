package io.clue2solve.bedrockspringbootstarterdemo;

import io.clue2solve.aws.bedrock.springboot.starter.autoconfigure.aimodels.BedrockAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(BedrockAutoConfiguration.class)
public class BedrockSpringBootStarterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedrockSpringBootStarterDemoApplication.class, args);
	}

}

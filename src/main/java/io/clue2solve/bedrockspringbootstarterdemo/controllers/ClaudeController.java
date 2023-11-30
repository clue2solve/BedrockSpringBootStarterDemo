package io.clue2solve.bedrockspringbootstarterdemo.controllers;

import io.clue2solve.aws.bedrock.springboot.starter.service.BedrockService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaudeController {

    private final BedrockService service;

    @Autowired
    public ClaudeController(@Qualifier("claudeService") BedrockService service) {
        this.service = service;
    }

    @PostMapping("/invoke")
    public String invokeClaude(@RequestBody String prompt) throws JsonProcessingException {
        return service.invoke(prompt);
    }
}
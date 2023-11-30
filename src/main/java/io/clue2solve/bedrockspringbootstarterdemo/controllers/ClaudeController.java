//package io.clue2solve.bedrockspringbootstarterdemo;

package io.clue2solve.bedrockspringbootstarterdemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.clue2solve.aws.bedrock.springboot.starter.service.ClaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaudeController {

    private final ClaudeService claudeService;

    @Autowired
    public ClaudeController(ClaudeService claudeService) {
        this.claudeService = claudeService;
    }

    @PostMapping("/invoke")
    public String invokeClaude(@RequestBody String prompt) throws JsonProcessingException {
        return claudeService.invokeClaude(prompt);
    }
}
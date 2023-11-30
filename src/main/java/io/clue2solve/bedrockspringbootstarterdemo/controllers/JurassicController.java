package io.clue2solve.bedrockspringbootstarterdemo.controllers;

import io.clue2solve.aws.bedrock.springboot.starter.service.BedrockService;
import io.clue2solve.aws.bedrock.springboot.starter.service.impl.JurassicService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jurassic")
public class JurassicController {

    private final BedrockService service;

    @Autowired
    public JurassicController(@Qualifier("jurassicService") BedrockService service) {
        this.service = service;
    }

    @PostMapping("/invoke")
    public String invokeJurassic(@RequestBody String prompt) throws JsonProcessingException {
        return service.invoke(prompt);
    }
}
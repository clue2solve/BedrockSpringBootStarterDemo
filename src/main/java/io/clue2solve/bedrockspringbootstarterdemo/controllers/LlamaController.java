package io.clue2solve.bedrockspringbootstarterdemo.controllers;

import io.clue2solve.aws.bedrock.springboot.starter.service.BedrockService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/llama")
public class LlamaController {

    private final BedrockService service;

    @Autowired
    public LlamaController(@Qualifier("llamaService") BedrockService service) {
        this.service = service;
    }

    @PostMapping("/invoke")
    public String invokeLlama(@RequestBody String prompt) throws JsonProcessingException {
        return service.invoke(prompt);
    }
}
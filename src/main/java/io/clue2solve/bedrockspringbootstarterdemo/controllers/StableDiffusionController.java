package io.clue2solve.bedrockspringbootstarterdemo.controllers;

import io.clue2solve.aws.bedrock.springboot.starter.service.BedrockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/stableDiffusion")
public class StableDiffusionController {

    private final BedrockService service;

    @Autowired
    public StableDiffusionController(@Qualifier("stableDiffusionService") BedrockService service) {
        this.service = service;
    }

    @PostMapping(value = "/invoke", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] invokeStableDiffusion(@RequestBody String prompt) throws Exception {
        String encodedImage = service.invoke(prompt);
        return Base64.getDecoder().decode(encodedImage);
    }
}
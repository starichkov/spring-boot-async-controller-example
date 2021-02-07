package org.starichkov.java.spring.async.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starichkov.java.spring.async.service.GeneratorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author Vadim Starichkov
 * @since 07.02.2021 18:23
 */
@Async("customTaskExecutor")
@RestController
@RequestMapping("generator")
public class ConcurrentRestController {

    private final GeneratorService generatorService;

    @Autowired
    public ConcurrentRestController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("uuid")
    public Future<String> generateRandomUUID() {
        return CompletableFuture.completedFuture(generatorService.generate());
    }
}

package org.starichkov.java.spring.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.starichkov.java.spring.async.controller.ConcurrentRestController;
import org.starichkov.java.spring.async.service.GeneratorService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationContextTest {

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private ConcurrentRestController concurrentRestController;

    @Test
    void contextLoads() {
        assertNotNull(generatorService);
        assertNotNull(concurrentRestController);
    }

}

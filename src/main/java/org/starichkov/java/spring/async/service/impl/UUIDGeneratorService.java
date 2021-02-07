package org.starichkov.java.spring.async.service.impl;

import org.springframework.stereotype.Service;
import org.starichkov.java.spring.async.service.GeneratorService;

import java.util.UUID;

/**
 * @author Vadim Starichkov
 * @since 07.02.2021 18:25
 */
@Service
public class UUIDGeneratorService implements GeneratorService {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}

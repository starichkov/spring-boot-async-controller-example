package org.starichkov.java.spring.async.controller;

import org.hamcrest.text.CharSequenceLength;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.starichkov.java.spring.async.service.GeneratorService;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Vadim Starichkov
 * @since 07.02.2021 18:35
 */
@WebMvcTest(ConcurrentRestController.class)
class ConcurrentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeneratorService generatorService;

    @Test
    void generateRandomUUID() {
        when(generatorService.generate())
                .thenReturn("100500");

        try {
            MvcResult mvcResult = mockMvc.perform(get("/generator/uuid"))
                                         .andExpect(request().asyncStarted())
                                         .andReturn();

            mockMvc.perform(asyncDispatch(mvcResult))
                   .andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(content().string(CharSequenceLength.hasLength(6)))
                   .andExpect(content().string(IsEqualIgnoringCase.equalToIgnoringCase("100500")));

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
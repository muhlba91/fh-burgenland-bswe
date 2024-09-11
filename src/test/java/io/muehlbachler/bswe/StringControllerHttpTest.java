package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerHttpTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testToUpperCase() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/upper?string=abc")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("ABC")));
    }

    @Test
    public void testToUpperCaseEmptyString() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/upper?string=")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("")));
    }
}

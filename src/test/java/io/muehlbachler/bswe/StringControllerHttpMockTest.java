package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;

@WebMvcTest(StringController.class)
class StringControllerHttpMockTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StringService stringService;

    @Test
    void testToUpperCase() throws Exception {
        when(stringService.toUpperCase("abc")).thenReturn("ABC");

        mvc.perform(MockMvcRequestBuilders.get("/upper?string=abc")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("ABC")));
        verify(stringService, times(1)).toUpperCase("abc");
    }

    @Test
    void testToUpperCaseEmptyString() throws Exception {
        when(stringService.toUpperCase("")).thenReturn("");

        mvc.perform(MockMvcRequestBuilders.get("/upper?string=")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("")));
        verify(stringService, times(1)).toUpperCase("");
    }
}

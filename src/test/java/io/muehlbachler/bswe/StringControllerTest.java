package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StringControllerTest {
    @Autowired
    private StringController controller;

    @MockBean
    private StringService service;

    @Test
    public void testToUpperCase() {
        when(service.toUpperCase("abc")).thenReturn("abc");

        assertEquals("ABC", controller.upper("abc"));
        verify(service, times(1)).toUpperCase("abc");
    }

    // FIXME: implement more tests
}

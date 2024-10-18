package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertEquals("abc", controller.upper("abc"));
        verify(service, times(1)).toUpperCase("abc");
    }

    @Test
    public void testToUpperCaseEmptyString() {
        when(service.toUpperCase("")).thenReturn("");

        assertEquals("", controller.upper(""));
        verify(service, times(1)).toUpperCase("");
    }

    @Test
    public void testToUpperCaseNullString() {
        when(service.toUpperCase(null)).thenReturn(null);

        assertEquals(null, controller.upper(null));
        verify(service, times(1)).toUpperCase(null);
    }
}

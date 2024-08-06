package io.muehlbachler.bswe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StringControllerTest {
    @Autowired
    private StringController controller;

    @MockBean
    private StringService service;

    @BeforeEach
    void setUp() {
        clearInvocations(service);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(service);
    }

    @Test
    public void testToUpperCase() {
        when(service.toUpperCase("abc")).thenReturn("ABC");

        assertEquals("ABC", controller.upper("abc"));
        verify(service, times(1)).toUpperCase("abc");
    }

    @Test
    public void testToUpperCaseNull() {
        when(service.toUpperCase(null)).thenReturn(null);

        assertEquals("", controller.upper(null));
        verify(service, times(1)).toUpperCase(null);
    }

    @Test
    public void testToLowerCase() {
        when(service.toLowerCase("ABC")).thenReturn("abc");

        assertEquals("abc", controller.lower("ABC"));
        verify(service, times(1)).toLowerCase("ABC");
    }

    @Test
    public void testToLowerCaseNull() {
        when(service.toLowerCase(null)).thenReturn(null);

        assertEquals("", controller.lower(null));
        verify(service, times(1)).toLowerCase(null);
    }
}

package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringServiceTest {
    private final StringService stringService = new StringService();

    @Test
    public void testToUpperCase() {
        assertEquals("ABC", stringService.toUpperCase("abc"), "abc toUpperCase should be ABC");
    }

    @Test
    public void testToUpperCaseNull(){
        assertEquals("", stringService.toUpperCase(null), "null toUpperCase should be empty string");
    }
}

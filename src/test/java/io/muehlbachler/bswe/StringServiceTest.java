package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTest {
    private StringService stringService = new StringService();

    @Test
    public void testToUpperCase() {
        assertEquals("ABC", stringService.toUpperCase("abc"), "abc toUpperCase should be ABC");
    }

    @Test
    public void testToUpperCaseNull() {
        assertNull(stringService.toUpperCase(null));
    }

    @Test
    public void testToLowerCase() {
        assertEquals("abc", stringService.toLowerCase("ABC"), "ABC toLowerCase should be abc");
    }

    @Test
    public void testToLowerCaseNull() {
        assertNull(stringService.toLowerCase(null));
    }
}

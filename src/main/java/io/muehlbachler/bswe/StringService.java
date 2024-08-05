package io.muehlbachler.bswe;

import org.springframework.stereotype.Service;

/**
 * Service for string operations.
 */
@Service
public class StringService {
    /**
     * Converts the given string to uppercase.
     * 
     * @param string The string to convert.
     * @return The converted string.
     */
    public String toUpperCase(final String string) {
        return string == null ? null : string.toUpperCase();
    }

    /**
     * Converts the given string to lowercase.
     * 
     * @param string The string to convert.
     * @return The converted string.
     */
    public String toLowerCase(final String string) {
        return string == null ? null : string.toLowerCase();
    }
}

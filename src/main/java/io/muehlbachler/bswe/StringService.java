package io.muehlbachler.bswe;

import org.springframework.stereotype.Service;

/**
 * Service class responsible for string operations.
 * Provides functionality to convert strings to uppercase.
 */
@Service
public class StringService {
    /**
     * Converts the provided string to uppercase.
     *
     * Edge cases:
     * - If the input string is null, it returns null
     * - Input should be in string format
     * - If the input string is empty, it returns the empty string
     *
     * @param string the input string to be converted
     * @return the input string converted to uppercase, or null if the input is null
     */
    public String toUpperCase(final String string) {
        // FIXME: implement
        return string;
    }
}

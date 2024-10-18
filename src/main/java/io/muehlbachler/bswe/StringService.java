package io.muehlbachler.bswe;

import java.util.Locale;

import org.springframework.stereotype.Service;

/**
 * Service for string operations.
 */
@Service
public class StringService {
    /**
     * Converts a string to upper case.
     * If the input string is null, the result is null.
     * 
     * @param string the string to convert
     * @return the upper case string
     */
    public String toUpperCase(final String string) {
        return string == null ? null : string.toUpperCase(Locale.getDefault());
    }
}

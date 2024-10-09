package io.muehlbachler.bswe;

import org.springframework.stereotype.Service;

/**
 * This class provides a service for the string controller and adds operations to manipulate strings.
 */
@Service
public class StringService {
     /**
     * This method converts a string to upper case.
     * 
     * @param string  The input string that gets converted.
     * 
     * @return The upper case string.
     * 
     * @throws IllegalArgumentException Thrown if the string is null.
     */
    public String toUpperCase(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        return string.toUpperCase();
    }
}

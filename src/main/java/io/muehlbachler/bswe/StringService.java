package io.muehlbachler.bswe;

import org.springframework.stereotype.Service;

/**
 * Service class for String Operations
 */
@Service
public class StringService {

    /**
     * Method for converting a given string into uppercase letters
     * @param string the string to convert
     * @return the uppercase version of the string
     */
    public String toUpperCase(final String string) {
        if(string == null) return "";
        return string.toUpperCase();
    }
}

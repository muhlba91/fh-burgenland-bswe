package io.muehlbachler.bswe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class provides a controller for a request mapping.
 * Its core function is to provide a service for the string type and adds operations to manipulate strings.
 * 
 * @author Marcel-TO
 *         <p>
 *         &copy; Marcel-TO. All rights reserved.
 */
@RestController
public class StringController {
    /**
     * Represents the service provided for this controller
     * 
     * @see StringService
     */
    @Autowired
    private StringService stringService = new StringService();

    /**
     * This method converts a string to upper case.
     * 
     * @param text  The input string that gets converted.
     * 
     * @return The upper case string.
     * 
     * @throws IllegalArgumentException Thrown if the string is null.
     */
    @GetMapping("/upper")
    String upper(@RequestParam(value = "string") final String text) {
        return stringService.toUpperCase(text);
    }
}

package io.muehlbachler.bswe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for string operations.
 */
@RestController
public class StringController {
    @Autowired
    private final StringService stringService = new StringService();

    /**
     * Converts a string to upper case.
     * 
     * @param text the string to convert
     * @return the upper case string
     */
    @GetMapping("/upper")
    String upper(@RequestParam("string") final String text) {
        return stringService.toUpperCase(text);
    }
}

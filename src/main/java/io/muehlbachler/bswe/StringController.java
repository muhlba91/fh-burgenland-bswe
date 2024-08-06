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
    private StringService stringService = new StringService();

    /**
     * Converts the given text to uppercase.
     * 
     * @param text The text to convert.
     * @return The converted text.
     */
    @GetMapping("/upper")
    public String upper(@RequestParam(value = "string") final String text) {
        String result = stringService.toUpperCase(text);
        return result != null ? result : "";
    }

    /**
     * Converts the given text to lowercase.
     * 
     * @param text The text to convert.
     * @return The converted text.
     */
    @GetMapping("/lower")
    public String lower(@RequestParam(value = "string") final String text) {
        String result = stringService.toLowerCase(text);
        return result != null ? result : "";
    }
}

package io.muehlbachler.bswe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StringController {
    @Autowired
    private StringService stringService = new StringService();

    /**
     * Endpoint for creating an upparcase version of a given string
     * @param text the string that should be converted to uppercase
     * @return the upparcase string
     */
    @GetMapping("/upper")
    String upper(@RequestParam(value = "string") final String text) {
        return stringService.toUpperCase(text);
    }
}

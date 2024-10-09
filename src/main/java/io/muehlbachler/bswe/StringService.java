package io.muehlbachler.bswe;

import org.springframework.stereotype.Service;

/**
 * Service-Klasse, die die Logik zur Umwandlung von Zeichenketten verwendet wird
 */
@Service
public class StringService {

    /**
     * Konvertiert die übergebene Zeichenkette in Großbuchstaben
     * @param string Die zu konvertierende Zeichenkette
     * @return Die Zeichenkette in Großbuchstaben
     * @throws IllegalArgumentException Wenn die Eingabe null ist
     */
    public String toUpperCase(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("Die Eingabe darf nicht null sein.");
        }
        return string.toUpperCase();
    }
}

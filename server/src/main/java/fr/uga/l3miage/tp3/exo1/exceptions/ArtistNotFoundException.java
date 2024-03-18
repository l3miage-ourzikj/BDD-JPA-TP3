package fr.uga.l3miage.tp3.exo1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends Exception {
    public ArtistNotFoundException(String message) {
        super(message);
    }
}

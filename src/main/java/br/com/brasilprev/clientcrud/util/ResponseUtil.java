package br.com.brasilprev.clientcrud.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

import java.util.Optional;

public interface ResponseUtil {

    static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
        return (ResponseEntity) maybeResponse.map((response) -> {
            return ((BodyBuilder) ResponseEntity.ok()).body(response);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}


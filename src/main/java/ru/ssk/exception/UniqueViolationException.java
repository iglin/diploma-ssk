package ru.ssk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by user on 13.05.2016.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UniqueViolationException extends RuntimeException {

    private UniqueViolationException() {
    }

    public UniqueViolationException(String message) {
        super(message);
    }
}

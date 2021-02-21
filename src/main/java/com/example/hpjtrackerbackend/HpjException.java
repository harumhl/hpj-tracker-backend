package com.example.hpjtrackerbackend;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HpjException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public HpjException(HttpStatus status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public HpjException(Throwable cause, HttpStatus status, String message) {
        super(message, cause);
        this.message = message;
        this.status = status;
    }
}

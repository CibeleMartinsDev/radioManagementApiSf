package br.com.radio.management.api.domain.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

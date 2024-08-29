package br.com.radio.management.api.domain.exception;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException(String mensagem) {
        super(mensagem);
    }
}

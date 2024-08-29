package br.com.radio.management.api.domain.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
    
}

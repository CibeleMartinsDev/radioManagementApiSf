package br.com.radio.management.api.domain.exception;

public class ResourceUserInactivatedException extends RuntimeException {
    public ResourceUserInactivatedException(String mensagem){
        super(mensagem);
    }
}

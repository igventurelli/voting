package br.com.southsystem.voting.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> type) {
        super(type.getName() + " not found");
    }
}

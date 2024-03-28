package br.com.southsystem.voting.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> resourceType) {
        super(resourceType.getName() + " not found");
    }
}

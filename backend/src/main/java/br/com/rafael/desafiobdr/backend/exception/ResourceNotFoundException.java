package br.com.rafael.desafiobdr.backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;
    private String valorString;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super("%s não encontrado com %s : '%s'");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String valorString) {
        super("%s não encontrado com %s : '%s'");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valorString = valorString;
    }
}

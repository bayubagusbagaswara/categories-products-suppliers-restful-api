package com.ecommerce.exception;

import com.ecommerce.dto.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.Transient;

@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

    @Transient
    private transient MessageResponse messageResponse;

    private final String resourceName = "Category";
    private String fieldName;
    private Object fieldValue;

    public CategoryNotFoundException(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    private void setMessageResponse() {
        String message = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);
        messageResponse = new MessageResponse(404, message);
    }
}

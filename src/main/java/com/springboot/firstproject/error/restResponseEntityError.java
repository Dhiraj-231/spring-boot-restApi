package com.springboot.firstproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.firstproject.Entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class restResponseEntityError extends ResponseEntityExceptionHandler {
    /**
     * Exception handler for DepartmentNotFoundException.
     *
     * @param exception the exception thrown
     * @param request   the WebRequest object
     * @return ResponseEntity with appropriate status code and error message
     */
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
            WebRequest request) {

        // Create an ErrorMessage object with the exception message and HTTP status code
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        // Return a ResponseEntity with the appropriate status code and error message
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(message);

    }
}

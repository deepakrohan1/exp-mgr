package com.deepakrohan.expense.advices;

import com.deepakrohan.expense.dto.ExceptionResponse;
import com.deepakrohan.expense.exception.CategoryNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * Exception Handler to handle custom exceptions
 * ResponseEntityExceptionHandler should be extended
 */

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle individual expenses
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .timeOfException(LocalDateTime.now())
                .exception(exception.getMessage())
                .description(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(CategoryNotFoundException exception, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .timeOfException(LocalDateTime.now())
                .exception(exception.getMessage())
                .description(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * When they are custom validations
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .timeOfException(LocalDateTime.now())
                .exception("Validation Issues")
                .description(ex.getBindingResult().toString())
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

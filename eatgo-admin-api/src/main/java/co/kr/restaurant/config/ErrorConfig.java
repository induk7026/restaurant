package co.kr.restaurant.config;

import co.kr.restaurant.store.domain.response.ValidResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidResponse> validException(MethodArgumentNotValidException e) {
        ValidResponse validResponse = ValidResponse.Builder.error(
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return ResponseEntity
                .badRequest()
                .body(validResponse);
    }
    
}

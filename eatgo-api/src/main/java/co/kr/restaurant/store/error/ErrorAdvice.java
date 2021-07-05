package co.kr.restaurant.store.error;

import co.kr.restaurant.store.error.domain.ApiError;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> illegal400(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> illegal400(NotFoundException e) {
        return ResponseEntity.badRequest().body(new ApiError(e.getMessage()));
    }
}

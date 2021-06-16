package co.kr.restaurant.error.domain;

import lombok.Getter;

@Getter
public class ApiError {

    private static final String ERROR = "error";

    private final String message;
    private final String status;

    public ApiError(String message) {
        this.message = message;
        this.status = ERROR;
    }
}

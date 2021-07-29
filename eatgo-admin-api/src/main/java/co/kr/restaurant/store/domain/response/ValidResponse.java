package co.kr.restaurant.store.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ValidResponse {

    public static final boolean FAIL = false;
    public static final boolean OK = true;
    private boolean success;
    private String message;
    private Object data;

    public static final class Builder {
        private boolean success;
        private String message;
        private Object data;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public static ValidResponse error(String message) {
           return new Builder()
                   .success(FAIL)
                   .message(message)
                   .build();
        }

        public static ValidResponse ok(String message) {
            return new Builder()
                    .success(FAIL)
                    .message(message)
                    .build();
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public ValidResponse build() {
            return new ValidResponse(success, message, data);
        }
    }
}

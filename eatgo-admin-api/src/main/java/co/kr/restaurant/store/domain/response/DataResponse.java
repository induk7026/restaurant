package co.kr.restaurant.store.domain.response;

import co.kr.restaurant.store.domain.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataResponse {

    public static final boolean FAIL = false;
    public static final boolean OK = true;

    private boolean success;
    private String message;
    private String status;
    private Object data;

   public static <T> DataResponse OK(T data) {
       DataResponse response = new DataResponse();
       response.status = MessageType.OK.name();
       response.data = data;
       response.success = OK;
       return response;
   }

    public static <T> DataResponse FAIL(MessageType type, String msg) {
        DataResponse response = new DataResponse();
        response.status = type.name();
        response.message = msg;
        response.success = FAIL;
        return response;
    }
}

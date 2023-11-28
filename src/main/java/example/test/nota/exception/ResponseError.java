package example.test.nota.exception;

import lombok.Data;

import java.util.Date;

/**
 * ResponseError
 *
 * @author Grigory Dyakonov
 */

@Data
public class ResponseError {
    int status;
    String message;
    Date timestamp;

    public ResponseError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}

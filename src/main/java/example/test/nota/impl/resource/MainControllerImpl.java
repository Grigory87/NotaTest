package example.test.nota.impl.resource;

import example.test.nota.api.controller.MainController;
import example.test.nota.api.dto.RequestDto;
import example.test.nota.exception.ResponseError;
import example.test.nota.impl.service.Calculating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainControllerImpl
 *
 * @author Grigory Dyakonov
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainControllerImpl implements MainController {
    private final Calculating calculating;

    @Override
    public ResponseEntity<?> countingLetters(RequestDto requestDto) {
        log.info("Call method countingLetters");
        if (requestDto.getText().isEmpty()) {
            log.warn("Request is empty");
            return new ResponseEntity<>(new ResponseError(
                    HttpStatus.BAD_REQUEST.value(), "Request is empty"),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(calculating.countingLetters(requestDto.getText()));
    }
}

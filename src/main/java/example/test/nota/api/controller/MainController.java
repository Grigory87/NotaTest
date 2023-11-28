package example.test.nota.api.controller;

import example.test.nota.api.dto.RequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController
 *
 * @author Grigory Dyakonov
 */


@Tag(name = "MainController", description = "Считает количество вхождений")
@ApiResponse(responseCode = "200", description = "Successful operation")
@ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
@RequestMapping("/api/v1")
public interface MainController {

    @PostMapping("/calculation")
    @Operation(summary = "Результат подсчёта", description = "Позволяет получить карту вхождений символов в строке" +
            "с количеством повторений")
    ResponseEntity<?> countingLetters(@RequestBody RequestDto requestDto);
}

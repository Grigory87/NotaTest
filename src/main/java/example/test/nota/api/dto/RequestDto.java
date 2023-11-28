package example.test.nota.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * RequestDto
 *
 * @author Grigory Dyakonov
 */

@Data
@Schema(description = "Dto запроса")
public class RequestDto {
    @Schema(description = "Строка для подсчета")
    private String text;
}

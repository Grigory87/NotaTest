package example.test.nota.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * OpenApiConfig
 *
 * @author Grigory Dyakonov
 */

@OpenAPIDefinition(
        info = @Info(
            title = "NotaTest",
            description = "<b>Counts the number of occurrences of characters</b>",
            version = "1.0.0",
                contact = @Contact(name = "Grigory Dyakonov")
        )
)
public class OpenApiConfig {
}

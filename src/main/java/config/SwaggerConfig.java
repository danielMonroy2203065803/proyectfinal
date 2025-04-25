package config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Información general de la API
                .info(new Info()
                        .title("API de Gestión de Facturación")
                        .version("1.0")
                        .description("Documentación para los servicios de Productos y Facturas Electrónicas")
                        .contact(new config.Contact()
                                .name("Tu Equipo")
                                .email("contacto@ejemplo.com")
                                .url("https://github.com/tu-repositorio"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                // Servidores (útil para ambientes múltiples)
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor de Desarrollo"))
                .addServersItem(new Server()
                        .url("https://api.tudominio.com")
                        .description("Servidor de Producción"));
    }
}
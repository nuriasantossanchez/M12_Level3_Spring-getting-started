package springBootInitialDemo_Level_III.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.TimeZone;

/**
 * Clase de la capa de Configuration de Spring
 * Extiende a la clase WebMvcConfigurationSupport que proporciona la configuración principal de MVC Java.
 * Por lo general, se importa agregando @EnableWebMvc a una clase de aplicación @Configuration.
 * Una opción alternativa más avanzada es extender directamente esta clase y sobreescribir métodos
 * según sea necesario, recordando agregar @Configuration a la subclase y @Bean para sobreescribir
 * métodos @Bean.
 *
 * Anotaciones:
 *
 * @ComponentScan
 * Utilizada junto a la anotacion @Configuration.
 * Configura directivas de análisis de componentes
 * Proporciona soporte en paralelo con el elemento <context:component-scan> de Spring XML.
 * Especifica basePackages(valor de alias), para definir paquetes específicos para escanear.
 * Si no se definen paquetes específicos, se realizará un escaneo desde el paquete de la
 * clase que declara esta anotación
 *
 * @Configuration
 * Indica que una clase declara uno o más métodos @Bean y puede ser procesada por el contenedor Spring
 * para generar definiciones de beans y solicitudes de servicio para esos beans en tiempo de ejecución
 *
 * @EnableWebMvc
 * Utilizada junto a la anotacion @Configuration.
 * Habilita la configuración predeterminada de Spring MVC y registra los componentes de infraestructura
 * MVC de Spring esperados por el DispatcherServlet.
 * A su vez, eso importará DelegatingWebMvcConfiguration, que proporciona la configuración predeterminada
 * de Spring MVC.
 *
 */
@ComponentScan(basePackages = {"springBootInitialDemo_Level_III"})
@Configuration
@EnableWebMvc
public class WebMVCConfiguration extends WebMvcConfigurationSupport {

    /**
     * Crear un controlador de recursos proporcionando los patrones de ruta de URL para lo cual se
     * debe invocar al controlador para que sirva recursos estáticos (por ejemplo, "/**").
     * Luego, use métodos adicionales del ResourceHandlerRegistration para agregar una o más
     * ubicaciones desde las que entregar contenido estático (por ejemplo, {"/", "classpath:/ META-INF/resources/"})
     * o para especificar un período de caché para los recursos servidos.
     *
     * @param registry, instancia de tipo ResourceHandlerRegistry, almacena registros de controladores de
     *                  recursos para servir recursos estáticos como imágenes, archivos css y otros a través
     *                  de Spring MVC, incluida la configuración de encabezados de caché optimizados para una
     *                  carga eficiente en un navegador web.
     *                  Los recursos se pueden servir desde ubicaciones en la raíz de la aplicación web,
     *                  desde la classpath y otros.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
    }

    /**
     * Metodo que retorna un objeto de tipo ObjectMapper que proporciona funcionalidad para leer y escribir JSON,
     * ya sea hacia y desde POJOs básicos, o hacia y desde un modelo de árbol JSON de propósito general (JsonNode),
     * así como funcionalidad para realizar conversiones.
     * Es altamente personalizable para trabajar con diferentes estilos de contenido JSON y para admitir conceptos
     * de objetos más avanzados, como polimorfismo e identidad de objetos.
     *
     * ObjectMapper también actúa como una fábrica para clases ObjectReader y ObjectWriter.
     * Mapper (y los ObjectReaders, ObjectWriters que construye) usará instancias de JsonParser y
     * JsonGenerator para implementar la lectura/escritura real del JSON.
     *
     * @return instancia de la clase ObjectMapper que sobreescribe la zona horaria predeterminada
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getDefault());
        return mapper;
    }
}
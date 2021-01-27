package springBootInitialDemo_Level_III;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase que usa para arrancar y lanzar una aplicación Spring desde el método main de Java.
 * Por defecto, la clase realiza los siguientes pasos para arrancar su aplicación:
 * Crea una instancia de ApplicationContext adecuada (según la ruta del classpath)
 * Registra un CommandLinePropertySource para exponer argumentos de línea de comando como propiedades de Spring
 * Actualiza el contexto de la aplicación, cargando todos los beans singleton
 * Activa cualquier bean CommandLineRunner
 *
 * Anotaciones:
 * @SpringBootApplication
 * Indica una clase de configuración que declara uno o más métodos @Bean y también activa la
 * configuración automática y el escaneo de componentes.
 * Esta es una anotación de conveniencia que equivale a declarar @Configuration,
 * @EnableAutoConfiguration y @ComponentScan
 *
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

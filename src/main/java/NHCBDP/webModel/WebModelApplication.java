package NHCBDP.webModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebModelApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(WebModelApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(WebModelApplication.class, args);
	}
}

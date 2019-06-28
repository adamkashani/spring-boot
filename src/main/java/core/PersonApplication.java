package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(PersonApplication.class, args);
		System.out.println(
				"the number of spring bean is : " + applicationContext.getBeanFactory().getBeanDefinitionCount());
	}
}
package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}


	/*@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("resources-message.propertiece","resources-error.propertiece");
		messageSource.setDefaultEncoding("Utf-8");
		return messageSource;
	}*/

}

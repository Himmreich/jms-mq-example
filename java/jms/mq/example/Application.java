package jms.mq.example;

import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
@ImportResource("classpath:app-config.xml")
public class Application implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send(session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setStringProperty("VALUE", "value");
            return textMessage;
        });
	}
}
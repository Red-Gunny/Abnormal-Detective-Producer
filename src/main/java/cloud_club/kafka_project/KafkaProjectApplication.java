package cloud_club.kafka_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProjectApplication implements CommandLineRunner {

	private static String TOPIC_NAME = "FROM_SPRING";
	@Autowired
	private KafkaTemplate<Integer, String> template;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<10; i++) {
			template.send(TOPIC_NAME, "진짜로 갔는지?");
			System.out.println("send Test " + (i+1));
		}
		System.exit(0);
	}
}

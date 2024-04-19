package cloud_club.kafka_project;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProjectApplication {

//	private static String TOPIC_NAME = "test";
//	@Autowired
//	private KafkaTemplate<Integer, String> template;
//
//	public static Logger logger = LoggerFactory.getLogger(KafkaProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);
	}

//	@KafkaListener(topics = "test",
//	groupId = "test-group-00")
//	public void recordListener(ConsumerRecord<String, String> record) {
//		logger.info("group ID : test-group-00");
//		logger.info(record.toString());
//	}
//
//	@KafkaListener(topics = "test",
//			groupId = "test-group-01")
//	public void singleTopicListener(String messageValue) {
//		logger.info("group ID : test-group-01");
//		logger.info(messageValue);
//	}
//
//	@KafkaListener(topics = "test",
//			groupId = "test-group-02",
//			properties = {
//					"max.poll.interval.ms:60000",
//					"auto.offset.reset:earliest"
//			})
//	public void singleTopicWithPropertiesListener(String messageValue) {
//		logger.info(messageValue);
//	}
//
//	@KafkaListener(topics = "test",
//			groupId = "test-group-03",
//			concurrency = "3")
//	public void concurrentTopicListener(String messageValue) {
//		logger.info(messageValue);
//	}
//
//	@KafkaListener(topics = "test",
//			groupId = "test-group-03",
//			concurrency = "3")
//	public void listenSpecificPartition(ConsumerRecord<String, String> record) {
//		logger.info(record.toString());
//	}

}

package cloud_club.kafka_project;

import cloud_club.kafka_project.service.AbnormalCheckService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 3,
        brokerProperties = {
                "listeners=PLAINTEXT://localhost:9092"
        },
        ports = { 9092 })
class ProducerTest {

    @Autowired
    AbnormalCheckService producer;



    @Test
    void test() throws Exception {

        // when
        producer.sendMessage("hong", "test-content");
        Thread.sleep(2000);


    }
}

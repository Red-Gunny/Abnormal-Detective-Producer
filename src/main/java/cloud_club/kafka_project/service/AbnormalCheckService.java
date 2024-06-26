package cloud_club.kafka_project.service;

import cloud_club.kafka_project.message.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class AbnormalCheckService {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<Integer, String> template;
    private HashMap<String, Long> msgSeqMap = new HashMap<>();

    public boolean sendMessage(String userId, String contents) throws JsonProcessingException {
        userId = userId == null ? UUID.randomUUID().toString() : userId;
        Long nextMsgSeq = msgSeqMap.getOrDefault(userId, -1L) + 1L;
        Message message = Message.builder()
                .userId(userId)
                .messageId(UUID.randomUUID().toString())
                .messageSeq(nextMsgSeq)
                .message(contents)
                .build();
        String sendMsg = objectMapper.writeValueAsString(message);
        template.send("message", sendMsg)
                .whenComplete((result, throwable) -> {
                    if(throwable == null) {
                        log.info("send successfully");
                    } else {
                        log.info("send error");
                    }
                });
        msgSeqMap.put(userId, nextMsgSeq);
        return true;
    }

}

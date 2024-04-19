package cloud_club.kafka_project.controller;

import cloud_club.kafka_project.dto.AbnormalMessageRequestDto;
import cloud_club.kafka_project.dto.AbnormalMessageResponseDto;
import cloud_club.kafka_project.service.AbnormalCheckService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageProducerController {

    private static final Logger log = LoggerFactory.getLogger(MessageProducerController.class);

    private final AbnormalCheckService checkService;

    @PostMapping("/message")
    public ResponseEntity<AbnormalMessageResponseDto> checkAbnormalMessage(@RequestBody AbnormalMessageRequestDto requestDto) throws JsonProcessingException {
        log.info("Received message: {}", requestDto.getMessage());
        boolean result = checkService.sendMessage(requestDto.getUserId(), requestDto.getMessage());
        AbnormalMessageResponseDto responseDto = new AbnormalMessageResponseDto();
        responseDto.setUserId(requestDto.getUserId());
        if(Boolean.TRUE.equals(result)) {
            responseDto.setResult(String.valueOf(result));
        } else {
            responseDto.setResult("Send Error");
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}

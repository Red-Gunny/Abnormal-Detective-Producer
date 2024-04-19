package cloud_club.kafka_project.message;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Message {
    private final String userId;
    private final String messageId;
    private final Long messageSeq;
    private final String message;
}

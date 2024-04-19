package cloud_club.kafka_project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbnormalMessageRequestDto {
    private String userId;
    private String message;
}

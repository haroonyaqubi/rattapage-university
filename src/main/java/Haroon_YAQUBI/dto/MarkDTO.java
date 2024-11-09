package Haroon_YAQUBI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarkDTO {

    private Float value;

    private UUID studentId;

    private Long subjectId;
}

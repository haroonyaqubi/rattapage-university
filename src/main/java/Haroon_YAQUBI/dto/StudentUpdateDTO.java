package Haroon_YAQUBI.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentUpdateDTO {

    private String first_name;

    private String last_name;

    private String email;

    private LocalDate birthed_at;

    private String number;
}

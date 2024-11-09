package Haroon_YAQUBI.entity;


import Haroon_YAQUBI.Json_Views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.TeacherShowView.class)
    private String first_name;

    @Column(nullable = false)
    @JsonView(JsonViews.TeacherShowView.class)
    private String last_name;

}
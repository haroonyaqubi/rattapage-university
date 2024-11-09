package Haroon_YAQUBI.entity;


import Haroon_YAQUBI.Json_Views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView({JsonViews.TeacherShowView.class, JsonViews.SubjectShowView.class})
    private String name;

    @Column(nullable = false)
    @JsonView(JsonViews.SubjectShowView.class)
    private String code;

    @ManyToOne
    @JsonView(JsonViews.SubjectShowView.class)
    @JoinColumn(nullable = false)
    private Teacher teacher;


}
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViews.StudentShowView.class)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private String first_name;

    @Column(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private String last_name;

    @Column(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private String email;

    @Column(nullable = false)
    private LocalDate birthed_at;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private LocalDate created_at;


}
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
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.MarkShowView.class)
    private Float value;

    @Column(nullable = false)
    @JsonView(JsonViews.MarkShowView.class)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Subject subject;
    
}
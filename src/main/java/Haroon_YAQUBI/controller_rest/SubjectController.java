package Haroon_YAQUBI.controller_rest;

import Haroon_YAQUBI.Json_Views.JsonViews;
import Haroon_YAQUBI.dto.SubjuctDTO;
import Haroon_YAQUBI.entity.Subject;
import Haroon_YAQUBI.serivce.SubjectService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping
    public List<Subject> list() {
        return subjectService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.SubjectShowView.class)
    public Subject show(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.SubjectShowView.class)
    public Subject create(@RequestBody SubjuctDTO subjectDTO) {
        return subjectService.createSubject(subjectDTO);
    }
}

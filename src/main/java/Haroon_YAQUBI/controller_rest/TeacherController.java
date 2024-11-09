package Haroon_YAQUBI.controller_rest;
import Haroon_YAQUBI.Json_Views.JsonViews;
import Haroon_YAQUBI.dto.StudentDTO;
import Haroon_YAQUBI.dto.TeacherDTO;
import Haroon_YAQUBI.entity.Teacher;
import Haroon_YAQUBI.serivce.TeacherService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> list() {
        return teacherService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.TeacherShowView.class)
    public Teacher show(@PathVariable String id) {
        return teacherService.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.TeacherShowView.class)
    public Teacher create(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.createTeacher(teacherDTO);
    }
}

package Haroon_YAQUBI.controller_rest;

import Haroon_YAQUBI.Json_Views.JsonViews;
import Haroon_YAQUBI.dto.StudentDTO;
import Haroon_YAQUBI.dto.StudentUpdateDTO;
import Haroon_YAQUBI.entity.Student;
import Haroon_YAQUBI.serivce.StudentService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public List<Student> list() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.StudentShowView.class)
    public Student show(@PathVariable String id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student create(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

}

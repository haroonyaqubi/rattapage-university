package Haroon_YAQUBI.serivce;

import Haroon_YAQUBI.dto.StudentDTO;
import Haroon_YAQUBI.dto.StudentUpdateDTO;
import Haroon_YAQUBI.entity.Student;
import Haroon_YAQUBI.entity.Teacher;
import Haroon_YAQUBI.repository.StudentRepository;
import Haroon_YAQUBI.serivce.interfaces.ListServiceInterface;
import Haroon_YAQUBI.serivce.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class StudentService implements ListServiceInterface<Student>, ServiceInterface<Student, String> {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirst_name(studentDTO.getFirst_name());
        student.setLast_name(studentDTO.getLast_name());
        student.setEmail(studentDTO.getEmail());
        student.setBirthed_at(LocalDate.now());
        student.setCreated_at(LocalDate.now());
        student.setNumber("");
        return studentRepository.save(student);
    }


    public Student StudentUpdate(StudentUpdateDTO dto, String uuid) {
        // Fetch the student by UUID
        Student student = studentRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + uuid));

        // Update the student's details
        student.setFirst_name(dto.getFirst_name());
        student.setLast_name(dto.getLast_name());
        student.setEmail(dto.getEmail());

        if (dto.getBirthed_at() != null) {
            student.setBirthed_at(dto.getBirthed_at());
        }
        if (dto.getNumber() != null) {
            student.setNumber(dto.getNumber());
        }

        // Save and return the updated student
        return studentRepository.save(student);
    }
}







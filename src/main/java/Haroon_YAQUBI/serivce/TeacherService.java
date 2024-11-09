package Haroon_YAQUBI.serivce;

import Haroon_YAQUBI.dto.TeacherDTO;
import Haroon_YAQUBI.entity.Teacher;
import Haroon_YAQUBI.repository.TeacherRepository;
import Haroon_YAQUBI.serivce.interfaces.ListServiceInterface;
import Haroon_YAQUBI.serivce.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TeacherService implements ListServiceInterface<Teacher>, ServiceInterface<Teacher, String> {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(String id) {
        return teacherRepository.findById((id))
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setFirst_name(teacherDTO.getFirst_name());
        teacher.setLast_name(teacherDTO.getLast_name());
        return teacherRepository.save(teacher);
    }



}







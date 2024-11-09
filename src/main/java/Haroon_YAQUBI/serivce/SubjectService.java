package Haroon_YAQUBI.serivce;

import Haroon_YAQUBI.dto.SubjuctDTO;
import Haroon_YAQUBI.entity.Subject;
import Haroon_YAQUBI.entity.Teacher;
import Haroon_YAQUBI.repository.SubjectRepository;
import Haroon_YAQUBI.repository.TeacherRepository;
import Haroon_YAQUBI.serivce.interfaces.ListServiceInterface;
import Haroon_YAQUBI.serivce.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService implements ListServiceInterface<Subject>, ServiceInterface<Subject, Long> {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<Subject> list() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(String id) {
        return null;
    }


    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Subject createSubject(SubjuctDTO subjectDTO) {
        System.out.println("Received teacherId: " + subjectDTO.getTeacherId());  // Log the teacherId

        Teacher teacher = teacherRepository.findById(String.valueOf(subjectDTO.getTeacherId()))
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + subjectDTO.getTeacherId()));

        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subject.setCode(subjectDTO.getCode());
        subject.setTeacher(teacher);

        return subjectRepository.save(subject);
    }

}

package Haroon_YAQUBI.serivce;

import Haroon_YAQUBI.dto.MarkDTO;
import Haroon_YAQUBI.entity.Mark;
import Haroon_YAQUBI.entity.Student;
import Haroon_YAQUBI.entity.Subject;
import Haroon_YAQUBI.repository.MarkRepository;
import Haroon_YAQUBI.repository.StudentRepository;
import Haroon_YAQUBI.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public Mark createMark(MarkDTO markDTO) {
        UUID studentId = markDTO.getStudentId();
        Long subjectId = markDTO.getSubjectId();

        Student student = studentRepository.findById(String.valueOf(studentId))
                .orElseThrow(EntityNotFoundException::new);
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(EntityNotFoundException::new);

        Mark mark = new Mark();
        mark.setValue(markDTO.getValue());
        mark.setStudent(student);
        mark.setSubject(subject);
        mark.setCreatedAt(LocalDate.now());

        return markRepository.save(mark);
    }
}

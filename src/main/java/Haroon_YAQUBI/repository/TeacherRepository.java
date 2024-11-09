package Haroon_YAQUBI.repository;

import Haroon_YAQUBI.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String > {

}

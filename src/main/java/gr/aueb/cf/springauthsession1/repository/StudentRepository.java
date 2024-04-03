package gr.aueb.cf.springauthsession1.repository;

import gr.aueb.cf.springauthsession1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}

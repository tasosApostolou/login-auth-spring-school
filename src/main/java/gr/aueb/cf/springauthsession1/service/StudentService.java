package gr.aueb.cf.springauthsession1.service;

import gr.aueb.cf.springauthsession1.dto.RegisterStudentDTO;
import gr.aueb.cf.springauthsession1.mapper.Mapper;
import gr.aueb.cf.springauthsession1.model.Student;
import gr.aueb.cf.springauthsession1.model.User;
import gr.aueb.cf.springauthsession1.repository.StudentRepository;
import gr.aueb.cf.springauthsession1.repository.UserRepository;
import gr.aueb.cf.springauthsession1.service.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.springauthsession1.service.exceptions.StudentAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    @Override
    public List<Student> findAllStudents() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student registerStudent(RegisterStudentDTO dto) throws StudentAlreadyExistsException {
        Student student;
        User user;
        try {
            student = Mapper.extractStudentFromRegisterStudentDTO(dto);
            user = Mapper.extractUserFromRegisterStudentDTO(dto);
            Optional<User> returnedUser = userRepository.findByUsername(dto.getUsername());
            if(returnedUser.isPresent()) throw new StudentAlreadyExistsException(Student.class,dto.getUsername());
            student.addUser(user);
            studentRepository.save(student);
            log.info("student register succesfully");
        }catch (StudentAlreadyExistsException  e){
            log.error("problem in saving student "+ e.getMessage());
            throw e;
        }
        return student;
    }
}

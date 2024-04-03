package gr.aueb.cf.springauthsession1.service;

import gr.aueb.cf.springauthsession1.dto.RegisterStudentDTO;
import gr.aueb.cf.springauthsession1.model.Student;
import gr.aueb.cf.springauthsession1.service.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.springauthsession1.service.exceptions.StudentAlreadyExistsException;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudents() throws Exception;

    Student registerStudent(RegisterStudentDTO dto) throws StudentAlreadyExistsException;
}

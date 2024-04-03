package gr.aueb.cf.springauthsession1.mapper;

import gr.aueb.cf.springauthsession1.dto.RegisterStudentDTO;
import gr.aueb.cf.springauthsession1.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsession1.model.*;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private Mapper() {}

    public static Teacher extractTeacherFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        return new Teacher(dto.getFirstname(), dto.getLastname(), true);
    }

    public static User extractUserFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        User user = User.NEW_TEACHER(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }

    public static Student extractStudentFromRegisterStudentDTO(RegisterStudentDTO dto){
        return new Student(dto.getFirstname(), dto.getLastname(), true);
    }

    public static User extractUserFromRegisterStudentDTO(RegisterStudentDTO dto){
        User user = User.NEW_STUDENT(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }

}

package gr.aueb.cf.springauthsession1.controller;

import gr.aueb.cf.springauthsession1.model.Student;
import gr.aueb.cf.springauthsession1.repository.StudentRepository;
import gr.aueb.cf.springauthsession1.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;
    @GetMapping("/students/dashboard")
    public String dashboard(Model model) throws Exception{
        List<Student> students;
        try {
           students = studentService.findAllStudents();
           model.addAttribute("students",students);
        }catch (Exception e){
            throw e;
        }
        return "/students/dashboard";

    }
}

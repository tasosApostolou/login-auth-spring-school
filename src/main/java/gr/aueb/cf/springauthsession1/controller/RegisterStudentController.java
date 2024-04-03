package gr.aueb.cf.springauthsession1.controller;

import gr.aueb.cf.springauthsession1.dto.RegisterStudentDTO;
import gr.aueb.cf.springauthsession1.model.Student;
import gr.aueb.cf.springauthsession1.service.IStudentService;
import gr.aueb.cf.springauthsession1.service.IUserService;
import gr.aueb.cf.springauthsession1.service.StudentService;
import gr.aueb.cf.springauthsession1.service.exceptions.StudentAlreadyExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterStudentController {

    private final IStudentService studentService;
    private final IUserService userService;


    @GetMapping("/students/register")
    public String login(Model model) {
        model.addAttribute("userForm", new RegisterStudentDTO());
        return "register";
    }

    @PostMapping("/students/register")
    public String registration(@Valid @ModelAttribute("userForm") RegisterStudentDTO studentDTO,
                               BindingResult bindingResult) throws StudentAlreadyExistsException {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            Student createdStudent = studentService.registerStudent(studentDTO);
        } catch (StudentAlreadyExistsException e) {
            throw e;
        }

        return "redirect:/login";
    }

}


package kz.didar.spring_project.controller;

import kz.didar.spring_project.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    private List<Student> students = new ArrayList<>();
    private long id = 1;

    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String showAddForm(Student student) {
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(Student student) {
        student.setId(id++);
        student.setMark(calculateMark(student.getExam()));
        students.add(student);
        return "redirect:/";
    }

    private String calculateMark(int exam) {
        if (exam >= 90) {
            return "A";
        } else if (exam >= 75) {
            return "B";
        } else if (exam >= 60) {
            return "C";
        } else if (exam >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}

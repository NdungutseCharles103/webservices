package rw.ac.rca.webservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.webservices.models.Student;
import rw.ac.rca.webservices.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    final
    StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("")
    public String getStudent() {
        return "Hello Student 1234";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getbyage/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable("age") int age) {
        List<Student> students = studentRepo.findByAge(age);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody() Student st) {
        Student newStudent = studentRepo.save(st);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody() Student st, @RequestParam("id") String id) {
        Student availableStudent = studentRepo.findById(id).get();
        availableStudent.setAge(st.getAge());
        availableStudent.setFirstName(st.getFirstName());
        availableStudent.setLastName(st.getLastName());
        // availableStudent.setGender(st.getGender());
        Student updatedStudent = studentRepo.save(availableStudent);
        return ResponseEntity.ok(updatedStudent);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) {
        studentRepo.deleteById(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
package com.example.reactCrud.StudService;

import com.example.reactCrud.Entity.Student;
import com.example.reactCrud.Repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setLastName(studentDetails.getLastName());
        student.setCity(studentDetails.getCity());
        student.setMobile(studentDetails.getMobile());
        student.setCountry(studentDetails.getCountry());
        student.setDateOfBirth(studentDetails.getDateOfBirth());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

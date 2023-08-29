package com.example.StudentServices.Service;

import com.example.StudentServices.DTO.StudentResponse;
import com.example.StudentServices.Entity.Student;
import com.example.StudentServices.Repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepo studentRepo;

    public List<StudentResponse> findAll(){
        List<Student> user = studentRepo.findAll();
        return user.stream().map(this::mapToStudentResponse).toList();
    }

    public Optional<StudentResponse> findById(String id) {
        return studentRepo.findById(id).map(this::mapToStudentResponse);
    }

    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getSid())
                .enroll(student.getEnroll())
                .faculty(student.getFaculty())
                .user(student.getUser())
                .build();
    }

    public StudentResponse findByUid(String id) {
        Student student = studentRepo.findStudentByUser_Id(id);
        return mapToStudentResponse(student);
    }


}

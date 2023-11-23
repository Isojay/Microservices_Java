package com.example.UserServices.Service;

import com.example.UserServices.DTO.StudentResponse;
import com.example.UserServices.DTO.UserResponse;
import com.example.UserServices.Entity.Student;
import com.example.UserServices.Entity.User;
import com.example.UserServices.Repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.UserServices.DTO.UserDTO;

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
        User user = student.getUser();
        return StudentResponse.builder()
                .id(student.getSid())
                .enroll(student.getEnroll())
                .faculty(student.getFaculty())
                .user(UserResponse.builder()
                        .id(user.getId())
                        .fname(user.getFname())
                        .lname(user.getLname())
                        .contact(user.getContact())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .created(user.getCreated())
                        .addressCity(user.getAddressCity())
                        .updated(user.getUpdated())
                        .addressCountry(user.getAddressCountry())
                        .isEnabled(user.isEnabled())
                        .build())
                .build();
    }

    public StudentResponse findByUid(String id) {
        Student student = studentRepo.findStudentByUser_Id(id);
        return mapToStudentResponse(student);
    }


}

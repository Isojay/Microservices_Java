package com.example.StudentServices.Service;

import com.example.StudentServices.DTO.UserDTO;
import com.example.StudentServices.DTO.UserResponse;
import com.example.StudentServices.Entity.Role;
import com.example.StudentServices.Entity.Staff;
import com.example.StudentServices.Entity.Student;
import com.example.StudentServices.Entity.User;
import com.example.StudentServices.Repo.StaffRepo;
import com.example.StudentServices.Repo.StudentRepo;
import com.example.StudentServices.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final StudentRepo studentRepo;
    private final StaffRepo staffRepo;

    public void save( UserDTO userDTO){
        User user = User.builder()
                .id(RandomService.generateRandomString(10))
                .fname(userDTO.getFname())
                .lname(userDTO.getLname())
                .contact(userDTO.getContact())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .addressCity(userDTO.getAddressCity())
                .addressCountry(userDTO.getAddressCountry())
                .role(Role.valueOf(userDTO.getRole()))
                .created(LocalDateTime.now())
                .isEnabled(false)
                .build();
        userRepo.save(user);
        if(Objects.equals(userDTO.getForUser(), "Student")){
            Student student = new Student();
            student.setSid(RandomService.generateRandomString(10));
            student.setUser(user);
            student.setFaculty(userDTO.getFaculty());
            student.setEnroll(Year.now());
            studentRepo.save(student);
        }else {
            Staff staff = new Staff();
            staff.setId(RandomService.generateRandomString(5));
            staff.setUser(user);
            staff.setDepartment(userDTO.getDepartment());
            staff.setPosition(userDTO.getPosition());
        }
    }

    public List<UserResponse> findAll() {
        List<User> user = userRepo.findAll();
        return user.stream().map(this::mapToUserResponse).toList();
    }

    public Optional<UserResponse> findById(String Id) {
        return userRepo.findById(Id).map(this::mapToUserResponse);
    }

    public void deleteById(String id){
        userRepo.deleteById(id);
    }


    public void enableId(String id){
        User user = userRepo.findById(id).get();
        user.setEnabled(true);
        userRepo.save(user);
    }
    public UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .fname(user.getFname())
                .lname(user.getLname())
                .contact(user.getContact())
                .username(user.getUsername())
                .email(user.getEmail())
                .created(user.getCreated())
                .isEnabled(user.isEnabled())
                .build();
    }

}

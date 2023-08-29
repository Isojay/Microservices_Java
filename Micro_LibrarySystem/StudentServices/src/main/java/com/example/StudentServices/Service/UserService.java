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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public static String Uploaddir = "/home/blue/LBMS/Users";

    public void save( UserDTO userDTO){
        User user = userBuilder(userDTO);
        userRepo.save(user);
        if(Objects.equals(userDTO.getForUser(), "Student")){
            Student student = new Student();
            student.setSid(UtilService.generateRandomString(10));
            student.setUser(user);
            student.setFaculty(userDTO.getFaculty());
            student.setEnroll(Year.now());
            studentRepo.save(student);
        }else {
            Staff staff = new Staff();
            staff.setId(UtilService.generateRandomString(5));
            staff.setUser(user);
            staff.setDepartment(userDTO.getDepartment());
            staff.setPosition(userDTO.getPosition());
        }
    }
    public void editUser(UserDTO user, String id) {
       User user1 = userRepo.findById(user.getId()).get();
       user1.setUpdated(LocalDateTime.now());
       user1.setFname(user.getFname());
       user1.setLname(user.getLname());
       user1.setContact(user.getContact());
       user1.setEmail(user.getEmail());
       user1.setAddressCity(user.getAddressCity());
       user1.setAddressCountry(user.getAddressCountry());
       user1.setUsername(user1.getUsername());
       userRepo.save(user1);
    }

    public String changePass(UserDTO user, String newPass){
        try{
            User user1 = userRepo.findById(user.getId()).get();
            if(Objects.equals(user1.getPassword(), user.getPassword())){
                user1.setPassword(newPass);
            }
            return "Success";
        }catch (Exception e){
            log.error("I caught error",e.getMessage());
            return e.getMessage();
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

    //Used to enable the User
    public void enableId(String id){
        User user = userRepo.findById(id).get();
        user.setEnabled(true);
        userRepo.save(user);
    }

    //ADD Image to User
    public String addImg(MultipartFile file, String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            User user1 = user.get();
            if (file.isEmpty()) {
                return "Empty";
            }
            String originalName = file.getOriginalFilename();
            assert originalName != null;
            String fileExtension = originalName.substring(originalName.lastIndexOf('.'));
            String newName = id + fileExtension;
            user1.setImgName(newName);
            userRepo.save(user1);
            try {
                File destFile = new File(Uploaddir + File.separator + newName);
                file.transferTo(destFile);

                return ("Success");
            } catch (IOException e) {
                return ("Error uploading image: " + e.getMessage());
            }
        }
        return "Empty Id";
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
                .addressCity(user.getAddressCity())
                .updated(user.getUpdated())
                .addressCountry(user.getAddressCountry())
                .isEnabled(user.isEnabled())
                .build();
    }
    
    public User userBuilder(UserDTO userDTO){
        Role role;

        if (Objects.equals(userDTO.getForUser(), "Student")) {
            role = Role.USER;
        } else {
            role = Role.STAFF;
        }
        return User.builder()
                .id(UtilService.generateRandomString(10))
                .fname(userDTO.getFname())
                .lname(userDTO.getLname())
                .contact(userDTO.getContact())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .addressCity(userDTO.getAddressCity())
                .addressCountry(userDTO.getAddressCountry())
                .role(role)
                .created(LocalDateTime.now())
                .isEnabled(false)
                .build();
    }



}

package com.example.StudentServices.Controller;

import com.example.StudentServices.DTO.MsgResponse;
import com.example.StudentServices.DTO.StudentResponse;
import com.example.StudentServices.DTO.UserDTO;
import com.example.StudentServices.Entity.Student;
import com.example.StudentServices.Service.StudentService;
import com.example.StudentServices.Service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public")
public class PublicController {

    private final StudentService service;
    private final UserService userService;
    MsgResponse msgResponse =  new MsgResponse();


    @GetMapping
    public String hello(){
        return "hello";
    }



    @GetMapping("/findAll")
    public List<StudentResponse> findAll(){
        System.out.println("here");
        return service.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        userDTO.setForUser("Student");
        userService.save(userDTO);
    }

    @PutMapping
    public void editUser(@RequestBody UserDTO user, @RequestParam("id") String id){
        userService.editUser(user,id);
    }

    @GetMapping("/byId")
    public StudentResponse getById(@RequestParam("id") String id){
        Optional<StudentResponse> userDTO = service.findById(id);
        return userDTO.orElse(null);
    }



    @PutMapping("/changePass")
    public ResponseEntity<?> changePass(@RequestBody UserDTO user,
                                        @RequestParam("newPass") String newPass){
        String message = userService.changePass(user,newPass);
        if (Objects.equals(message, "Success")){
            msgResponse.setMessage("Password Sucessfully Changed");
            return ResponseEntity.ok(msgResponse);
        }else {
            return ResponseEntity.status(404).body(message);
        }
    }

    @GetMapping("/byUid")
    public StudentResponse finByUid(@RequestParam("id") String id){
        return service.findByUid(id);
    }

}

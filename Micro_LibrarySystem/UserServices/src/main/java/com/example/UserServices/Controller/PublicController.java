package com.example.UserServices.Controller;

import com.example.UserServices.DTO.ChangePassDTO;
import com.example.UserServices.DTO.MsgResponse;
import com.example.UserServices.DTO.StudentResponse;
import com.example.UserServices.DTO.UserDTO;
import com.example.UserServices.Service.StudentService;
import com.example.UserServices.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getById(@RequestParam("id") String id) {
        Optional<StudentResponse> userDTO = service.findById(id);
        if (userDTO.isPresent()) {
            return ResponseEntity.ok(userDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }




    @PutMapping("/changePass")
    public ResponseEntity<?> changePass(@RequestBody ChangePassDTO changePassDTO){
        String message = userService.changePass(changePassDTO);
        if (Objects.equals(message, "Success")){
            msgResponse.setMessage("Password Sucessfully Changed");
            return ResponseEntity.ok(msgResponse);
        }else {
            return ResponseEntity.status(404).body(message);
        }
    }

}

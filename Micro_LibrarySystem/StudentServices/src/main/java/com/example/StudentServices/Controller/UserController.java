package com.example.StudentServices.Controller;

import com.example.StudentServices.DTO.UserDTO;
import com.example.StudentServices.DTO.UserResponse;
import com.example.StudentServices.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void addStudent(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<UserResponse> user = userService.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public void enableIt(@PathVariable String id){
        userService.enableId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIt(@PathVariable String id){
        userService.deleteById(id);
    }

}

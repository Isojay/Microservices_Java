package com.example.StudentServices.Controller;

import com.example.StudentServices.DTO.UserResponse;
import com.example.StudentServices.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }
    @PostMapping("/{id}")
    public void enableIt(@PathVariable String id){
        userService.enableId(id);
    }

}

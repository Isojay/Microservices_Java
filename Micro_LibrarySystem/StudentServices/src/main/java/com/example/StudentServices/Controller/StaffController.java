package com.example.StudentServices.Controller;

import com.example.StudentServices.Service.StaffService;
import com.example.StudentServices.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class StaffController {

    private final StaffService staffService;
    private final StudentService studentService;

//    @GetMapping
//    public List<UserReponse>

}

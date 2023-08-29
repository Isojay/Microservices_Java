package com.example.UserServices.Controller;

import com.example.UserServices.Service.StaffService;
import com.example.UserServices.Service.StudentService;
import lombok.RequiredArgsConstructor;
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

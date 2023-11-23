package com.example.UserServices.Controller;


import com.example.UserServices.DTO.StudentResponse;
import com.example.UserServices.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @GetMapping("/byUid")
    public StudentResponse finByUid(@RequestParam("id") String id){
        return service.findByUid(id);
    }



}

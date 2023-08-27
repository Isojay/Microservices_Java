package com.example.StudentServices.Controller;

import com.example.StudentServices.Service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class StaffController {

    private final StaffService service;
}

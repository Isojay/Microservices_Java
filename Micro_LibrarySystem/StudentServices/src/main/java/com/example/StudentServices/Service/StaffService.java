package com.example.StudentServices.Service;


import com.example.StudentServices.Repo.StaffRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    private final StaffRepo staffRepo;

}



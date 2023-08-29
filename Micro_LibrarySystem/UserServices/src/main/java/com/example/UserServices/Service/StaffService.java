package com.example.UserServices.Service;


import com.example.UserServices.DTO.StaffResponse;
import com.example.UserServices.Entity.Staff;
import com.example.UserServices.Repo.StaffRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    private final StaffRepo staffRepo;

    public List<StaffResponse> findAll(){
        List<Staff> user = staffRepo.findAll();
        return user.stream().map(this::mapToStaffResponse).toList();
    }

    public Optional<StaffResponse> findById(String id) {
        return staffRepo.findById(id).map(this::mapToStaffResponse);
    }

    private StaffResponse mapToStaffResponse(Staff staff) {
        return StaffResponse.builder()
                .id(staff.getId())
                .department(staff.getDepartment())
                .position(staff.getPosition())
                .user(staff.getUser())
                .build();
    }

}



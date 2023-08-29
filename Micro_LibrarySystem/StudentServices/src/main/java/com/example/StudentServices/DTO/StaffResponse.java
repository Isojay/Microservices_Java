package com.example.StudentServices.DTO;

import com.example.StudentServices.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponse {
    private String id;
    private String department;
    private User user;
    private String position;
}

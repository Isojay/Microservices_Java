package com.example.UserServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoResp {

    private String id;
    private Year enroll;
    private String faculty;

}

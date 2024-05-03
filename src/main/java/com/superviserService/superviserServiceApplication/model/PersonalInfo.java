package com.superviserService.superviserServiceApplication.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String supervisor;
}

package com.superviserService.superviserServiceApplication.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Supervisor {

    private String id;
    private String phone;
    private String jurisdiction;
    private String identificationNumber;
    private String firstName;
    private String lastName;
}

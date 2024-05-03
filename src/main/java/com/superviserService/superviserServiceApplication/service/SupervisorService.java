package com.superviserService.superviserServiceApplication.service;

import com.superviserService.superviserServiceApplication.model.PersonalInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupervisorService {


  List<String> getSupervisors();


  ResponseEntity submitPersonalInfo(PersonalInfo personalInfo);

}

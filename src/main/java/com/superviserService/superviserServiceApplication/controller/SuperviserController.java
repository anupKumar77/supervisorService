package com.superviserService.superviserServiceApplication.controller;

import com.superviserService.superviserServiceApplication.model.PersonalInfo;
import com.superviserService.superviserServiceApplication.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperviserController {

    SupervisorService supervisorService;

    @Autowired
    SuperviserController(SupervisorService supervisorService){
        this.supervisorService=supervisorService;
    }

    @GetMapping("/api/supervisors")
    public ResponseEntity<List<String>> getSupervisors() {
        List<String> data=supervisorService.getSupervisors();
        return ResponseEntity.ok(data);
    }


    @PostMapping("/api/submit")
    public ResponseEntity<String> submitPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        return supervisorService.submitPersonalInfo(personalInfo);
    }

}

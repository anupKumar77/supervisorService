package com.superviserService.superviserServiceApplication.service.impl;

import com.superviserService.superviserServiceApplication.exception.CustomException;
import com.superviserService.superviserServiceApplication.model.PersonalInfo;
import com.superviserService.superviserServiceApplication.model.Supervisor;
import com.superviserService.superviserServiceApplication.service.SupervisorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
@Slf4j
public class SupervisorServiceImpl implements SupervisorService {
    @Value("${url}")
    String url;

    RestTemplate restTemplate;
    @Autowired
    SupervisorServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public List<String> getSupervisors() {
        try {

            Supervisor[] managers = restTemplate.getForObject(url, Supervisor[].class);
            return Arrays.stream(managers)
                    .filter(manager -> !isNumeric(manager.getJurisdiction()))
                    .map(manager -> manager.getJurisdiction() + " - " + manager.getLastName() + ", " + manager.getFirstName())
                    .sorted()
                    .collect(Collectors.toList())
                    ;
        } catch (Exception e) {
            e.printStackTrace();
           throw new CustomException("Internal Server Error");
        }
    }

    @Override
    public ResponseEntity submitPersonalInfo(PersonalInfo personalInfo) {
        if (personalInfo.getFirstName() == null || personalInfo.getLastName() == null || personalInfo.getSupervisor() == null) {
            throw new CustomException(
                    (personalInfo.getFirstName() == null ? "First name is required. " : "") +
                            (personalInfo.getLastName() == null ? "Last name is required. " : "") +
                            (personalInfo.getSupervisor() == null ? "Supervisor is required." : "")
            );
        }
        log.info("First Name: " + personalInfo.getFirstName());
        log.info("Last Name: " + personalInfo.getLastName());
        log.info("Supervisor: " + personalInfo.getSupervisor());
        log.info(Objects.isNull(personalInfo.getEmail()) ? "email is not provided!" :"Email: "+ personalInfo.getEmail());
        log.info(Objects.isNull(personalInfo.getPhoneNumber()) ? "phone number is not provided" : "Phone Number: " + personalInfo.getPhoneNumber());
        return ResponseEntity.ok("Data submitted successfully");
    }


    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

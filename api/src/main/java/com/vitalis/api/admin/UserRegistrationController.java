package com.vitalis.api.admin;


import com.vitalis.common.dto.DoctorRegistrationDto;
import com.vitalis.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserRegistrationController {
    private final DoctorService doctorService;

    public UserRegistrationController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorRegistrationDto doctorRegistrationDto) {
        doctorService.addDoctor(doctorRegistrationDto);
        return ResponseEntity.ok("Success");

    }

    @GetMapping("/doctor")
    public String addDoctor() {
        return "add-doctor";
    }
}

package com.example.Registration.Controller;

import com.example.Registration.WrapperObjects.UserWO;
import com.example.Registration.Service.RegistrationService;
import com.example.Registration.WrapperObjects.AccountWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RestTemplate restTemplate;





    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AccountWO newAccount ){

        boolean isValidRequest = registrationService.verifyNewAccount(newAccount);

        if(isValidRequest == false) return new ResponseEntity("403 ", HttpStatus.FORBIDDEN);

        registrationService.createConsumer(newAccount);

        registrationService.sendRequestToCreateAccount(newAccount);

        return new ResponseEntity<>("201 ", HttpStatus.CREATED);
    }



    @PostMapping("/delete")
    public void deleteUser (@RequestBody UserWO userWO){
        registrationService.deleteUser(userWO);
    }

}

package com.example.Accounts.Controller;



import com.example.Accounts.Service.AccountService;
import com.example.Accounts.Service.FriendService;
import com.example.Accounts.Utility.UtilityService;
import com.example.Accounts.WrapperObjects.CreateAccountWO;
import com.example.Accounts.WrapperObjects.LoginResponseWO;
import com.example.Accounts.WrapperObjects.LoginWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/internal")
public class InternalNetworkController {

    @Autowired
    public AccountService accountService;

    @Autowired
    public FriendService friendService;

    @Autowired
    public UtilityService utilityService;


    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountWO newAccount , HttpServletRequest request){

        boolean validSender = utilityService.isRequestFromRegistrationServer(request);

        if(validSender == false) return  new ResponseEntity<>("403", HttpStatus.FORBIDDEN);

        accountService.createAccount(newAccount);

        return new ResponseEntity<>("200 ok", HttpStatus.OK);
    }


    @PostMapping("/credentials")
    public ResponseEntity<LoginResponseWO> checkMyCredentials(@RequestBody LoginWO login , HttpServletRequest request){

        boolean validSender = utilityService.isRequestFromLoginServer(request);

        if(validSender == false) rejectCredentials();

        LoginResponseWO response = accountService.validateCredentials(login);

        if(response == null) rejectCredentials();


        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity rejectCredentials(){
        return  new ResponseEntity(null, HttpStatus.FORBIDDEN);
    }


}

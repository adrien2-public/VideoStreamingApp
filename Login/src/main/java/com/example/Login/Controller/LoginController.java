package com.example.Login.Controller;

import com.example.Login.WrapperObjects.LogoutWO;
import com.example.Login.Service.SessionService;
import com.example.Login.WrapperObjects.LoginResponseWO;
import com.example.Login.WrapperObjects.LoginWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private RestTemplate restTemplate;





    @PostMapping("/login")
    public ResponseEntity<LoginResponseWO> login(@RequestBody LoginWO loginVO, HttpServletRequest request){

        String username = loginVO.getUsername();
        String password = loginVO.getPassword();
        String ipAddress = request.getRemoteAddr();

        LoginResponseWO result = sessionService.validateLogin(username, password);

        System.out.println("logging in ");
        if(result == null) return  new ResponseEntity("403", HttpStatus.FORBIDDEN);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }





    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LogoutWO logout, HttpServletRequest request ){

       sessionService.deleteSessionByTimeStamp(logout);


        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}

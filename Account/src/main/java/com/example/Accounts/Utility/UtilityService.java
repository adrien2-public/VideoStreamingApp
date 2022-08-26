package com.example.Accounts.Utility;


import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UtilityService {



    public boolean isRequestFromRegistrationServer(HttpServletRequest request){
        String ipAddress = request.getRemoteAddr();
        if(ipAddress != "http://localhost:8504/"){
            return false;
        }
        return true;
    }


    public boolean isRequestFromLoginServer(HttpServletRequest request){
        String ipAddress = request.getRemoteAddr();
        if(ipAddress != "http://localhost:8503/"){
            return false;
        }
        return true;
    }




}

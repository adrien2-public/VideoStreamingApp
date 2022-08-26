package com.example.Login.Service;



import com.example.Login.WrapperObjects.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SessionService {


    @Autowired
    private RestTemplate restTemplate;



    @Value("${dockerizedHost}")
    private String host;






    public LoginResponseWO validateLogin(String username, String password){

        LoginWO login = new LoginWO(username, password);

        AuthResponseWO result = restTemplate.postForObject("http://" + host + ":8500/account/credentials",login, AuthResponseWO.class);

        System.out.println(result);
        if(result == null) return null;
        if(result.getUsername() == null) return null;
        if(result.getPassword() == null) return null;
        if(result == null) return null;

        LoginResponseWO loginResponse = new LoginResponseWO(result.getTheId(), result.getName());

        return loginResponse;
    }




    public void deleteSessionByTimeStamp(LogoutWO logout){
        long created_at = logout.getCreated_at();
        deleteKongSessionIfRequestIsLegit(created_at);
    }




    public void deleteKongSessionIfRequestIsLegit(long created_at){

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://" + host + ":8001/sessions/", Object.class);
        Object objects = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        LogoutWOfromKong myFriends = mapper.convertValue(objects  , new TypeReference<LogoutWOfromKong>() { });


        List<SessionWO> list = myFriends.getData();
        int arraySize = list.size();

        System.out.println(list.toString());

        for(int x=0; x < arraySize ; x++){
            if(list.get(x).getCreated_at() == created_at ){
                String deleteThis =  list.get(x).getId();
                restTemplate.delete("http://" + host + ":8001/sessions/" + deleteThis);
            }

        }
    }








}

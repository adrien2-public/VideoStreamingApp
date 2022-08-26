package com.example.Registration.Service;

import com.example.Registration.Repository.UserRepo;
import com.example.Registration.WrapperObjects.AccountWO;
import com.example.Registration.WrapperObjects.ConsumerCredentialsWO;
import com.example.Registration.WrapperObjects.ConsumerWO;
import com.example.Registration.WrapperObjects.UserWO;
import com.example.Registration.Entity.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dockerizedHost}")
    private String host;

    public boolean verifyNewAccount(AccountWO newAccount){

        String email = newAccount.getEmail();
        String uname = newAccount.getUsername();

        if (userRepo.getUserByEmail(email) != null) return false;
        if (userRepo.getUserByUsername(uname) != null) return false;
        userRepo.save(new User(email,uname));

        return true;
    }



    public void createConsumer(AccountWO account){

        String username = account.getUsername();
        String password = account.getPassword();

        ConsumerWO consumer = new ConsumerWO(username);

        ConsumerCredentialsWO consumerCredentials = new ConsumerCredentialsWO(username,password);

        restTemplate.postForObject("http://" + host + ":8001/consumers/" , consumer , ConsumerWO.class);

        restTemplate.postForObject("http://" + host + ":8001/consumers/" + username + "/basic-auth/" , consumerCredentials , ConsumerCredentialsWO.class);

    }

    public void sendRequestToCreateAccount(AccountWO account){

        restTemplate.postForObject("http://" + host + ":8500/account/create" , account, String.class );

    }


    public void deleteUser(UserWO userWO){

        String email = userWO.getEmail();
        if (userRepo.getUserByEmail(email) == null) return ;
        User user = userRepo.getUserByEmail(email);
        Long id = user.getId();
        userRepo.deleteById(id);
    }





}

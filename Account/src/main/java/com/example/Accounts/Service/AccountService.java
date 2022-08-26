package com.example.Accounts.Service;

import com.example.Accounts.Entity.Account;
import com.example.Accounts.Entity.Friend;
import com.example.Accounts.Repository.AccountRepo;
import com.example.Accounts.WrapperObjects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    public AccountRepo accountRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dockerizedHost}")
    private String host;


    @Autowired
    private PasswordEncoder passwordEncoder;




    public void createAccount(CreateAccountWO newAccount){

        String email = newAccount.getEmail();
        String fname = newAccount.getFirstName();
        String lname = newAccount.getLastName();
        String pword = newAccount.getPassword();
        String uname = newAccount.getUsername();
        String url;
        if(newAccount.getUrl() == null){
            url = "nothing";
        }else{
            url = newAccount.getUrl();
        }


        Account account = new Account(fname,lname, email, pword, uname, url );

        encodePassword(account);
        accountRepo.save(account);

    }

    public LoginResponseWO validateCredentials(LoginWO loginWO){

        String username = loginWO.getUsername();
        String password = loginWO.getPassword();

        Account account = accountRepo.getAccountByUserName(username);

        if(account == null) return null;

        if(passwordEncoder.matches(password, account.getPassword()) == false) return null;

        LoginResponseWO response = new LoginResponseWO(account.getId(), account.getFirstName(), username, password);

        return response;
    }



    public AccountWO getById(long id){

            Account account = accountRepo.getById(id);

            String username = account.getUserName();
            String fname = account.getFirstName();
            String lname = account.getLastName();
            String url = account.getUrl();
            AccountWO accountWrapper= new AccountWO(id,fname,lname,username, url  );

            return accountWrapper;
    }

    public AccountWO getWOByUsername(String username){

            Account account = accountRepo.getAccountByUserName(username);


            String fname = account.getFirstName();
            String lname = account.getLastName();
            String url = account.getUrl();
            long id = account.getId();
            AccountWO accountWrapper= new AccountWO(id,fname,lname,username, url  );

            return accountWrapper;
    }

    public Account getAccountByUsername(String username){

        Account account = accountRepo.getAccountByUserName(username);

        return account;
    }


    public Account editAccount(Account newAccount){

        Long id = newAccount.getId();
        Account account = accountRepo.getById(id);

            account.setEmail(newAccount.getEmail() );
            account.setFirstName( newAccount.getFirstName());
            account.setLastName( newAccount.getLastName());
            account.setUserName(newAccount.getUserName());

            encodePassword(newAccount);

            account.setPassword( newAccount.getPassword() );

            accountRepo.save(account);

            return account;

    }




    public void saveAccount (Account account){

            encodePassword(account);
            accountRepo.save(account);
            return;

    }


    public void deleteAccount (Long id, long unixTime){
        Account account = accountRepo.getById(id);
        UserWO user = new UserWO(account.getEmail(), account.getUserName());

            deleteKongSession(unixTime);
            accountRepo.delete(account);
            restTemplate.postForObject("http://" + host + ":8505/registration/delete",user, UserWO.class );

    }

    public void deleteKongSession(Long created_at){
        KongSessionObjects sessionObjVO =   restTemplate.getForObject("http://" + host + ":8001/sessions/", KongSessionObjects.class);

        List<SessionWO> list = sessionObjVO.getData();
        int arraySize = list.size();

        for(int x=0; x < arraySize ; x++){
            if(list.get(x).getCreated_at() == created_at ){
                String deleteThis =  list.get(x).getId();
                restTemplate.delete("http://" + host + ":8001/sessions/" + deleteThis);
            }
        }
    }


    public Account getByEmail(String email){
        Account account =  accountRepo.getAccountByEmail(email);
        return account;
    }


    public List<FriendsWO> getMyFriends(Long accountId, List<Friend> friends){

        List<FriendsWO> friendsWrapperObject = new ArrayList<>();
        for(int x = 0; x < friends.size(); x++){
           if(accountId != friends.get(x).getFriendId()){
               Long id = friends.get(x).getFriendId();
               String username  = friends.get(x).getUsername();
               String name = friends.get(x).getFriendName();
               friendsWrapperObject.add( new FriendsWO(name, username, id));
           }
            if(accountId == friends.get(x).getFriendId()){
                Account account = accountRepo.getById(friends.get(x).getAccountId());
                Long id = account.getId();
                String username  = account.getUserName();
                String name = account.getFirstName();
                friendsWrapperObject.add( new FriendsWO(name, username, id));
            }
        }

        return friendsWrapperObject;
    }


    private void encodePassword(Account account){
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
    }






}

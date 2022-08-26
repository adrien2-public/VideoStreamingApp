package com.example.Accounts.Controller;



import com.example.Accounts.Entity.Account;
import com.example.Accounts.Entity.Friend;
import com.example.Accounts.Service.AccountService;
import com.example.Accounts.Service.FriendService;
import com.example.Accounts.Utility.UtilityService;
import com.example.Accounts.WrapperObjects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    public AccountService accountService;

    @Autowired
    public FriendService friendService;


    @Autowired
    public UtilityService utilityService;




    @GetMapping("/{accountId}")
    public ResponseEntity<AccountWO> getAccount(@PathVariable(value="accountId") Long accountId , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        AccountWO account =  accountService.getById(accountId);

        if(account == null){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AccountWO> getAccount(@PathVariable(value="username") String username , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        AccountWO account =  accountService.getWOByUsername(username);

        if(account == null){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }



    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable(value="accountId") Long accountId, HttpServletRequest request){
        String timestamp = request.getHeader("timestamp");
        long unixTime = Long.valueOf(timestamp);
        String ipAddress = request.getRemoteAddr();
        accountService.deleteAccount(accountId,unixTime);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    @PutMapping("/{accountId}")
    public ResponseEntity<String> editAccount(@PathVariable(value="accountId") int accountId, @RequestBody Account newAccount , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
       Account account =  accountService.editAccount(newAccount);

        if(account == null){
            return new ResponseEntity("403 Forbidden", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("200 OK", HttpStatus.OK);
    }


    @GetMapping("/{accountId}/friends")
    public ResponseEntity<List<FriendsWO>> getFriends(@PathVariable(value="accountId") Long accountId , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        List<Friend> friendIds = friendService.getFriendIdList(accountId);

        if(friendIds == null){
            return new ResponseEntity( HttpStatus.NO_CONTENT);
        }

        List<FriendsWO> myListOfFriends = accountService.getMyFriends(accountId, friendIds);

        return new ResponseEntity<>(myListOfFriends, HttpStatus.OK);

    }


    @PostMapping("/{accountId}/friends")
    public ResponseEntity<String> sendFriendRequest(@PathVariable(value="accountId") Long accountId, @RequestBody FriendRequest req  , HttpServletRequest request){


        String ipAddress = request.getRemoteAddr();

        Account accountOfFriend = accountService.getAccountByUsername(req.getUsername());

        Long friendId = accountOfFriend.getId();

        friendService.sendFriendRequest(accountId,friendId);

        return new ResponseEntity<>("201 ok", HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}/friends/incoming")
    public ResponseEntity<List<AccountWO>> getIncomingRequests(@PathVariable(value="accountId") Long accountId , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        List<AccountWO> list = friendService.getRequestList(accountId);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    @PostMapping("/{accountId}/friends/{friendId}")
    public  ResponseEntity<String> acceptOrDenyFriend(@PathVariable(value="accountId") Long accountId,
                               @PathVariable(value="friendId") Long friendId, String response , HttpServletRequest request){


        String ipAddress = request.getRemoteAddr();
        if(response == "accept"){
            friendService.acceptFriendRequest(accountId,friendId);
        }else{
            friendService.denyFriendRequest(accountId,friendId);
        }

        return new ResponseEntity<>("201 ok", HttpStatus.CREATED);
    }



    @GetMapping("/{accountId}/friends/{friendId}")
    public  ResponseEntity<Friend> getFriend(@PathVariable(value="accountId") Long accountId,
                                                      @PathVariable(value="friendId") Long friendId , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();

        if(friendService.getSpecificFriend(accountId, friendId) == null) return null;

        Friend friend = friendService.getSpecificFriend(accountId, friendId);

        return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }


    @DeleteMapping("/{accountId}/friends/{friendId}")
    public  ResponseEntity<String> deleteFriend(@PathVariable(value="accountId") Long accountId,
                                             @PathVariable(value="friendId") Long friendId , HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();

        if(friendService.getSpecificFriend(accountId, friendId) == null) return null;

        friendService.deleteFriend(accountId, friendId);

        return new ResponseEntity<>( HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountWO newAccount , HttpServletRequest request){

        accountService.createAccount(newAccount);

        return new ResponseEntity<>("200 ok", HttpStatus.OK);
    }


    @PostMapping("/credentials")
    public ResponseEntity<LoginResponseWO> checkMyCredentials(@RequestBody LoginWO login , HttpServletRequest request){

        LoginResponseWO response = accountService.validateCredentials(login);

        if(response == null) return  new ResponseEntity("403", HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }






}

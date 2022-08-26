package com.example.Accounts.Service;



import com.example.Accounts.Entity.Account;
import com.example.Accounts.Entity.Friend;
import com.example.Accounts.Entity.PendingFriendRequests;
import com.example.Accounts.Repository.AccountRepo;
import com.example.Accounts.Repository.FriendRepo;
import com.example.Accounts.Repository.PendingFriendRequestsRepo;
import com.example.Accounts.WrapperObjects.AccountWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class FriendService {


    @Autowired
    private FriendRepo friendRepo;

    @Autowired
    private PendingFriendRequestsRepo pendingFriendRequestsRepo;

    @Autowired
    AccountRepo accountRepo;

    @Value("${dockerizedHost}")
    private String host;




    public void sendFriendRequest(Long accountId, Long receiverId ){

            PendingFriendRequests request = new PendingFriendRequests(accountId, receiverId);
            pendingFriendRequestsRepo.save(request);

    }

    public  List<AccountWO> getRequestList(Long accountId){

        List<PendingFriendRequests>  incomingReq =pendingFriendRequestsRepo.getMyIncomingFriendRequests(accountId);
        List<AccountWO> accountList = new LinkedList<>();

        for(int x = 0; x < incomingReq.size(); x++){
           long initiator = incomingReq.get(x).getAccountId();
            Account account =  accountRepo.getById(initiator);
            String firstName = account.getFirstName();
            String lastName = account.getLastName();
            long number = account.getId();
            String username = account.getUserName();
            String url = account.getUrl();
            AccountWO acct = new AccountWO(number,firstName, lastName,username, url );

            accountList.add(acct);
        }
            return accountList;
    }

    public void acceptFriendRequest(Long accountId, Long senderId){

            PendingFriendRequests x = pendingFriendRequestsRepo.getMyIncomingRequest(accountId, senderId);
            pendingFriendRequestsRepo.delete(x);

            Account friendAccount = accountRepo.getById(senderId);
            String friendName =friendAccount.getFirstName();
            String friendUsername = friendAccount.getUserName();

            Friend friend = new Friend(accountId, senderId, friendName, friendUsername  );
            friendRepo.save(friend);


    }


    public void denyFriendRequest(Long accountId, Long friendId){

            PendingFriendRequests x = pendingFriendRequestsRepo.getMyIncomingRequest(accountId, friendId);
            pendingFriendRequestsRepo.delete(x);
    }


    public List<Friend> getFriendIdList (Long accountId){

            List<Friend> friends = friendRepo.getAllFriendshipsForAccount(accountId);
            return friends ;
    }

    public Friend getSpecificFriend(Long accountId, Long friendId){

        friendRepo.getSpecificFriendship(accountId, friendId);

            if(friendRepo.getSpecificFriendship(accountId, friendId) == null) return null;
            return friendRepo.getSpecificFriendship(accountId, friendId);

    }

    public void deleteFriend(Long accountId, Long friendId){

        if(friendRepo.getSpecificFriendship(accountId, friendId) != null){
            Friend friend = friendRepo.getSpecificFriendship(accountId, friendId);
            friendRepo.delete(friend);
        }

    }

    public void save(Friend friend){

        friendRepo.save(friend);
    }



}

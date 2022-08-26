package com.example.Accounts.Repository;



import com.example.Accounts.Entity.PendingFriendRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingFriendRequestsRepo extends JpaRepository<PendingFriendRequests, Long> {

    @Query("SELECT f FROM PendingFriendRequests f WHERE (f.accountId = :senderId) AND (f.receiverId = :accountId)")
    public PendingFriendRequests getMyIncomingRequest(@Param("accountId") Long accountId, @Param("senderId") Long senderId);


    @Query("SELECT f FROM PendingFriendRequests f WHERE (f.receiverId = :receiverId) ")
    public List<PendingFriendRequests> getMyIncomingFriendRequests(@Param("receiverId") Long accountId);


    @Query("SELECT f FROM PendingFriendRequests f WHERE (f.accountId = :senderId) ")
    public List<PendingFriendRequests> getMyOutboundFriendRequests(@Param("senderId") Long accountId);

}

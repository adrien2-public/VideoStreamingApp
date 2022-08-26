package com.example.Messages.Repository;

import com.example.Messages.Entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, Long> {

    @Query("SELECT c FROM Conversation c WHERE c.convostarterId = :convostarterId")
    public List<Conversation> getByConvoStarter(@Param("convostarterId") Long convostarterId);


    @Query("SELECT c FROM Conversation c WHERE c.convoReceiverId = :convoReceiverId")
    public List<Conversation> getByConvoRecipient(@Param("convoReceiverId") Long convoReceiverId);


    @Query("SELECT c FROM Conversation c WHERE c.convoReceiverId = :convoReceiverId  " +
            "AND c.convostarterId = :convostarterId")
    public  Conversation getByConvoBetweenTwoPeople(@Param("convoReceiverId") Long convoReceiverId,
                                                    @Param("convostarterId") Long convostarterId);


    @Query("SELECT c FROM Conversation c WHERE c.convostarterId = :accountId OR c.convoReceiverId = :accountId")
    public List<Conversation> getConversationWithAccountId(@Param("accountId") Long accountId);



}

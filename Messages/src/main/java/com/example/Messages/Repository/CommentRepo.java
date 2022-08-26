package com.example.Messages.Repository;


import com.example.Messages.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE (c.conversationId = :conversationId) " +
            "ORDER BY c.timestamp" )
    public List<Comment> getCommentsByConversationId(@Param("conversationId") Long conversationId);




}

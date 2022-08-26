package com.example.Messages.Service;


import com.example.Messages.Entity.Comment;
import com.example.Messages.Entity.Conversation;
import com.example.Messages.Repository.CommentRepo;
import com.example.Messages.Repository.ConversationRepo;


import com.example.Messages.WrapperOjects.CommentWO;
import com.example.Messages.WrapperOjects.ConversationListWO;
import com.example.Messages.WrapperOjects.ConversationWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ConversationRepo conversationRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dockerizedHost}")
    private String host;


    public ConversationListWO getConversationByAccountId(Long accountId){

        List<Conversation> list = conversationRepo.getConversationWithAccountId(accountId);

        if(list == null) return null;

        ConversationListWO conversationListWO  = new ConversationListWO();

        for(int x = 0 ; x < list.size() ; x++){

            long conversationId = list.get(x).getId();
            List<Comment> commentList = getComments(conversationId);
            long starter = list.get(x).getConvostarterId();
            long receiver = list.get(x).getConvoReceiverId();
            LocalDateTime time = list.get(x).getTimestamp();

            ConversationWO conversationWO = new ConversationWO(conversationId,starter, receiver,time, commentList );

            conversationListWO.addConversationsWO(conversationWO);

        }

        return conversationListWO;
    }




    /*

       public ConversationListWO getConversationByAccountId(Long accountId){

        List<Conversation> initiated =  conversationRepo.getByConvoStarter(accountId);
        List<Conversation> received =  conversationRepo.getByConvoRecipient(accountId);
        ConversationListWO convoList = new ConversationListWO();

        if(initiated != null){
            generateConversation(initiated, convoList);
        }


        if(received != null){
            generateConversation(received, convoList);
        }

        if(received == null && initiated != null) return null;

        return convoList;
    }

    public void generateConversation( List<Conversation> conversations,  ConversationListWO convoList){

        for(int x = 0 ; x < conversations.size() ; x++){

            Long convoId =   conversations.get(x).getId();
            Conversation conversation = conversations.get(x);

            List<Comment> comList = getComments(convoId);

            convoList.setId(x);
            long starter = conversation.getConvostarterId();
            long receiver = conversation.getConvoReceiverId();
            LocalDateTime time = conversation.getTimestamp();
            long id = conversation.getId();

            convoList.addConversationsWO(new ConversationWO( id,starter,receiver,time,comList));

        }

    }


     */


    public ConversationWO getConversationById(Long id){

        Conversation conversation =  conversationRepo.getById(id);

        if(conversation == null) return null;

        List<Comment> comList = getComments(id);

        long starter = conversation.getConvostarterId();
        long receiver = conversation.getConvoReceiverId();
        LocalDateTime time = conversation.getTimestamp();

        var conversationObject = new ConversationWO( id,starter,receiver,time,comList);


        return conversationObject;
    }


    public boolean startConversation(long accountId, long friendId){

        Conversation conversation  = conversationRepo.getByConvoBetweenTwoPeople(accountId, friendId);
        Conversation conversation2  = conversationRepo.getByConvoBetweenTwoPeople(friendId, accountId);

        if(conversation != null) return false;
        if(conversation2 != null) return false;

        Conversation convo = new Conversation(accountId, friendId);

        conversationRepo.save(convo);

        return true;
    }


    public boolean deleteConversation(long conversationId){

        Conversation conversation  = conversationRepo.getById(conversationId);

        if(conversation == null) return false;

        conversationRepo.delete(conversation);

        return true;
    }










    public List<Comment> getComments(Long conversationId){

        List<Comment> commentList = commentRepo.getCommentsByConversationId(conversationId);

        return  commentList;
    }




    public  List<Conversation> getConversationList(Long accountId){

        List<Conversation> list = conversationRepo.getConversationWithAccountId(accountId);

        return list;
    }


    public boolean validateConversation(CommentWO commentWO, long conversationId){

       long senderId =  commentWO.getSenderId();
        long receiverId = commentWO.getRecipientId();

        Conversation converstation = conversationRepo.getById(conversationId);

        long id1 = converstation.getConvoReceiverId();
        long id2 = converstation.getConvostarterId();

        if(senderId == id1 && receiverId == id2 ) return true;
        if(receiverId == id1 && senderId == id2  ) return true;


        return false;
    }

    public void makeComment(CommentWO commentWO){

        String body =  commentWO.getBody();
        long convoId = commentWO.getConversationId();
        long recipientId =  commentWO.getRecipientId();
        long senderId =  commentWO.getSenderId();
        String authorName = commentWO.getAuthorName();



        Comment newComment = new Comment(convoId,senderId,recipientId,body, authorName );

        commentRepo.save(newComment);

        return  ;
    }



}

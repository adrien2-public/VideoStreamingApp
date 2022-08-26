package com.example.Messages.Controller;


import com.example.Messages.Entity.Conversation;
import com.example.Messages.Repository.CommentRepo;
import com.example.Messages.Repository.ConversationRepo;
import com.example.Messages.Service.MessageService;
import com.example.Messages.WrapperOjects.CommentWO;
import com.example.Messages.WrapperOjects.ConversationListWO;
import com.example.Messages.WrapperOjects.ConversationWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    MessageService conversationService;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ConversationRepo conversationRepo;


    @GetMapping("/give")
    public ResponseEntity<List<Conversation> > gimme(){

        List<Conversation> convo =  conversationService.getConversationList(1L);

        if(convo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(convo, HttpStatus.OK);
    }

    @GetMapping("/{conversationId}/accounts/{accountId}")
    public ResponseEntity<ConversationWO> getConversationById(@PathVariable(value="conversationId") long conversationId
            , @PathVariable(value="accountId") long accountId){

        ConversationWO convo =  conversationService.getConversationById(conversationId);

        if(convo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(convo, HttpStatus.OK);
    }

    @GetMapping("/conversations/accounts/{accountId}")
    public ResponseEntity<ConversationListWO> getConversationsForAccountId(@PathVariable(value="accountId") long accountId){

        ConversationListWO convo =  conversationService.getConversationByAccountId(accountId);

        if(convo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(convo, HttpStatus.OK);
    }


    @PostMapping("/conversations/accounts/{accountId}/{friendId}")
    public ResponseEntity<String> startConversation(@PathVariable(value="friendId") long friendId, @PathVariable(value="accountId") long accountId){


        boolean validOperation = conversationService.startConversation(accountId,friendId);

        if(validOperation == false) return new ResponseEntity(HttpStatus.CONFLICT);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


    @GetMapping("/conversations/accounts/{accountId}/list")
    public ResponseEntity<List<Conversation>> getConversationList(@PathVariable(value="accountId") long accountId){


        List<Conversation> convo =  conversationService.getConversationList(accountId);


        return new ResponseEntity(convo, HttpStatus.OK);
    }



    @DeleteMapping("/{accountId}/{conversationId}")
    public  ResponseEntity<String> deleteConversation(@PathVariable(value="accountId") long accountId,@PathVariable(value="conversationId") long conversationId ){

        boolean validOperation = conversationService.deleteConversation(conversationId);

        if(validOperation == false) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }



    @PostMapping("/{conversationId}")
    public ResponseEntity<String> makeComment(@RequestBody CommentWO comment, @PathVariable(value="conversationId") long conversationId, HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();


        if (conversationService.validateConversation(comment,conversationId)) return new ResponseEntity(HttpStatus.FORBIDDEN);
        
        conversationService.makeComment(comment);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }








}

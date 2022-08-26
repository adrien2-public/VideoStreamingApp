package com.example.Messages.WrapperOjects;

import java.util.ArrayList;
import java.util.List;

public class ConversationListWO {

    private long id;
    private List<ConversationWO> conversationList;

    public ConversationListWO() {

    }

    public ConversationListWO(List<ConversationWO> conversationList) {
        this.conversationList = conversationList;
    }



    public List<ConversationWO> getConversationList() {
        return conversationList;
    }

    public void addConversationsWO(ConversationWO conversationWO) {

        if(this.conversationList == null){
            List<ConversationWO> newlist = new ArrayList<>();
            newlist.add(conversationWO);
            this.conversationList = newlist;
            return;
        }

        this.conversationList.add(conversationWO);

    }
}

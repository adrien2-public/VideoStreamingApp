package com.example.Accounts.WrapperObjects;


import java.util.List;

public class KongSessionObjects {


    private List<SessionWO> data;
    private Object next;


    public KongSessionObjects() {

    }

    public KongSessionObjects(List<SessionWO> data, Object next) {
        this.data = data;
        this.next = next;
    }

    public List<SessionWO> getData() {
        return data;
    }

    public void setData(List<SessionWO> data) {
        this.data = data;
    }

    public void addData(SessionWO data) {
        this.data.add(data);
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }
}


package com.example.Login.WrapperObjects;

import java.util.ArrayList;
import java.util.List;

public class LogoutWOfromKong {


    private List<SessionWO> data;
    private Object next;


    public LogoutWOfromKong() {
        data = new ArrayList<>();
    }

    public LogoutWOfromKong(List<SessionWO> data, Object next) {
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

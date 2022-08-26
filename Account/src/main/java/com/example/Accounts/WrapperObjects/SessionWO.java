package com.example.Accounts.WrapperObjects;


public class SessionWO {

    private String id;
    private int ttl;
    private Long created_at;
    private String session_id;
    private Long expires;
    private String data;

    public SessionWO() {

    }

    public SessionWO(String id, int ttl, Long created_at, String session_id, Long expires, String data) {
        this.id = id;
        this.ttl = ttl;
        this.created_at = created_at;
        this.session_id = session_id;
        this.expires = expires;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


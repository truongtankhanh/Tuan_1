package com.gmail.khanhit100896.myapplication;

public class User {
    String session_id, uid, user_context, db, username, company_id, partner_id;

    public User(String session_id, String uid, String user_context, String db, String username, String company_id, String partner_id) {
        this.setSession_id(session_id);
        this.setUid(uid);
        this.setUser_context(user_context);
        this.setDb(db);
        this.setUsername(username);
        this.setCompany_id(company_id);
        this.setPartner_id(partner_id);
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUser_context() {
        return user_context;
    }

    public void setUser_context(String user_context) {
        this.user_context = user_context;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }
}

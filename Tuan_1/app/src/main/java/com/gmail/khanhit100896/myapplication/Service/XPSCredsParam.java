package com.gmail.khanhit100896.myapplication.Service;

public class XPSCredsParam {
    public XPSCredsParamDetail params;

    public XPSCredsParam(String db, String login, String password) {
        this.params = new XPSCredsParamDetail(db, login, password);
    }

    /**
     * Created by Admin on 9/1/2017.
     */

    public static class XPSCredsParamDetail {
        public String db;
        public String login;
        public String password;

        public XPSCredsParamDetail(String db, String login, String password) {
            this.db = db;
            this.login = login;
            this.password = password;
        }
    }
}
package com.gmail.khanhit100896.myapplication;

    public class ResultUserLogin {
        private String username;
        private String uid;
        private String company_id;
        private String partner_id;
        private String db;
        private String session_id;
        private UserContext user_context;

        public ResultUserLogin(String username, String uid, String company_id, String partner_id, String db, String session_id, UserContext user_context) {
            this.username = username;
            this.uid = uid;
            this.company_id = company_id;
            this.partner_id = partner_id;
            this.db = db;
            this.session_id = session_id;
            this.user_context = user_context;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getDb() {
            return db;
        }

        public void setDb(String db) {
            this.db = db;
        }

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public UserContext getUser_context() {
            return user_context;
        }

        public void setUser_context(UserContext user_context) {
            this.user_context = user_context;
        }
        public class UserContext{
            private String lang;
            private String tz;
            private String uid;

            public UserContext(String lang, String tz, String uid) {
                this.lang = lang;
                this.tz = tz;
                this.uid = uid;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }
    }



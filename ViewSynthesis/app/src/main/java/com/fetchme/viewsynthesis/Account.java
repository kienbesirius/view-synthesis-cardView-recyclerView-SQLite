package com.fetchme.viewsynthesis;

import androidx.annotation.NonNull;

public class Account {
    private String account_id;
    private String account_password;

    @NonNull
    @Override
    public String toString() {
        return "Account{" +
                "id='" + account_id + '\'' +
                ", password='" + account_password + '\'' +
                '}';
    }

    public Account(String account_id, String account_password) {
        this.account_id = account_id;
        this.account_password = account_password;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }
}

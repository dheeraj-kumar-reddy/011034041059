package com.mycampus.Server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogoutForm {
    public long username;

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LogoutForm{" +
                "username='" + username + '\'' +
                '}';
    }
}

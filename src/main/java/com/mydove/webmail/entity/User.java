package com.mydove.webmail.entity;

import java.util.Properties;

import com.mydove.webmail.imap.Authentication;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

/**
 *
 * @author Stanislav Oginsky
 */
public class User {

    private String username;
    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void login(Properties props) throws NoSuchProviderException, MessagingException {
        Authentication auth = new Authentication(username, password);
        auth.connect(props);
    }

}

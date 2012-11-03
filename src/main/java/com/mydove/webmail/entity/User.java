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
    private Authentication auth = null;

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
        auth = new Authentication(username, password);
        auth.connect(props);
    }

	public boolean isAuthorized() {
		if (null != auth) 
			return auth.isConnected();
		return false;		
	}

}

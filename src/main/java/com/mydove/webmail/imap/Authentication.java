package com.mydove.webmail.imap;

import java.util.Properties;
import javax.mail.*;


/**
 *
 * @author Stanislav Oginsky
 */
public class Authentication extends Authenticator {

    private String username;
    private String password;
    private Store store = null;
    
    public Authentication() {
    }

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Session getSession(Properties props) {
        Session session = Session.getInstance(props, this);
        if (props.getProperty("imap.debug").equals("true")) {
            session.setDebug(true);
        }
        return session;
    }

    public void connect(Properties props) throws NoSuchProviderException,
            MessagingException {
        store = getSession(props).getStore(props.getProperty("store.protocol"));
        store.connect(props.getProperty("connect.host"), username, password);
    }
}

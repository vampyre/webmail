package com.mydove.webmail.imap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

/**
 *
 * @author Stanislav Oginsky
 */
public class ImapFolderImpl {

    Folder folder = null;
    Store store = null;
    Folder[] foldersList = null;

    public ImapFolderImpl() {
    }

    public ImapFolderImpl(Store store) {
        this.store = store;
    }

    public Folder[] getFoldersList(boolean isGetFromCache) {
        if ((isGetFromCache && foldersList == null)
                || (!isGetFromCache)) {
            try {
                foldersList = store.getDefaultFolder().list();
            } catch (MessagingException ex) {
                Logger.getLogger(ImapFolderImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return foldersList;
    }
}

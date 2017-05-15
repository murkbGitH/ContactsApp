package com.facade;

import com.dao.ContactDAO;
import com.model.Contact;


/**
 * Created by Pawel on 2017-05-15.
 */
public class ContactFacade {

    private ContactDAO contactDAO = new ContactDAO();

    public void createContact(Contact contact) {
        contactDAO.beginTransaction();
        contactDAO.save(contact);
        contactDAO.commitAndCloseTransaction();
    }
}

package com.dao;

import com.model.Contact;

/**
 * Created by Pawel on 2017-05-12.
 */

public class ContactDAO extends GenericDAO<Contact> {

    public ContactDAO() {
        super(Contact.class);
    }
}

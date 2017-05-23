package com.dao;

import com.model.Contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pawel on 2017-05-12.
 */

public class ContactDAO extends GenericDAO<Contact> {

    public ContactDAO() {
        super(Contact.class);
    }

    public Contact findContactByEmail(String email){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);

        return super.findOneResult(Contact.FIND_BY_EMAIL, parameters);
    }

    public void delete(Contact contact) {
        super.delete(contact.getId(), Contact.class);
    }
}

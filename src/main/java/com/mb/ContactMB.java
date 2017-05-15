package com.mb;

import com.model.Contact;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Pawel on 2017-05-15.
 */

@ViewScoped
@ManagedBean
public class ContactMB extends AbstractMB implements Serializable {

    private Contact contact;

    public Contact getContact() {
        if(contact==null){
            contact=new Contact();
        }
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

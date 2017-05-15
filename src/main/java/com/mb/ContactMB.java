package com.mb;

import com.facade.ContactFacade;
import com.model.Contact;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2017-05-12.
 */

@ViewScoped
@ManagedBean
public class ContactMB extends AbstractMB implements Serializable {

    private Contact contact;
    private ContactFacade contactFacade;
    private List<Contact> contactsList;
    private Contact contactDetails;

    public Contact getContact() {
        if(contact==null){
            contact=new Contact();
        }
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactFacade getContactFacade() {
        if(contactFacade==null){
            contactFacade=new ContactFacade();
        }
        return contactFacade;
    }

    public void setContactFacade(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    public List<Contact> getContactsList() {
        if(contactsList==null){
            contactsList=new ArrayList<Contact>();
        }
        return contactsList;
    }

    public void setContactsList(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public Contact getContactDetails() {
        if(contactDetails==null){
            contactDetails=new Contact();
        }
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void createContact(){
        try {
            getContactFacade().createContact(contact);
            closeDialog();
            displayInfoMessageToUser(" New Contact added with Success");
            loadContactsList();
            resetContact();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not create. Try again later");
            e.printStackTrace();
        }
    }

    public void deleteContact() {
        try {
            getContactFacade().deleteContact(contactDetails);
            closeDialog();
            displayInfoMessageToUser("Deleted with Success");
            loadContactsList();
            resetContact();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not delete. Try again later");
            e.printStackTrace();
        }
    }

    public void updateContact() {
        try {
            getContactFacade().updateContact(contactDetails);
            displayInfoMessageToUser("Updated With Success");
            resetContactDetails();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops, we could not update. Try again later");
            e.printStackTrace();
        }
    }

    public void resetContact(){
        contact = new Contact();
    }

    public void resetContactDetails(){
        contactDetails = new Contact();
    }

    public void loadContactsList() {
        contactsList = getContactFacade().listAll();
        if(contactsList==null){
            contactsList=new ArrayList<Contact>();
        }
    }

    public List<Contact> getAllContacts() {
        if (contactsList == null) {
            loadContactsList();
        }
        return contactsList;
    }

}

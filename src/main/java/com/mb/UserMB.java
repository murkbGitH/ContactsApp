package com.mb;

import com.facade.ContactFacade;
import com.facade.UserFacade;
import com.model.Contact;
import com.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Pawel on 2017-05-12.
 */
@SessionScoped
@ManagedBean(name="userMB")
public class UserMB extends  AbstractMB implements Serializable {

    public static final String INJECTION_NAME = "#{userMB}";

    private User user;
    private UserFacade userFacade;
    private Contact contact;
    private ContactFacade contactFacade;

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserFacade getUserFacade() {
        if (userFacade == null) {
            userFacade = new UserFacade();
        }
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

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

    public void resetUser() {
        user = new User();
    }
    public void resetContact() {
        contact = new Contact();
    }

    public String register() {
        try {
            userFacade = new UserFacade();

            if (!userFacade.emailAlreadyExists(user.getEmail())) {
                userFacade.createUser(user);
                contactFacade.createContact(contact);
                closeDialog();
                displayInfoMessageToUser("Register with success!");
                resetUser();
                resetContact();
                return "/pages/public/loginOrRegister.xhtml";
            }
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Register failed!");
            e.printStackTrace();
        }
        return null;
    }


}
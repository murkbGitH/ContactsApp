package com.facade;

import com.dao.ContactDAO;
import com.model.Contact;

import java.util.List;


/**
 * Created by Pawel on 2017-05-12.
 */
public class ContactFacade {

    private ContactDAO contactDAO = new ContactDAO();

    public boolean emailAlreadyExists(String email) {
        contactDAO.beginTransaction();
        Contact contact = contactDAO.findContactByEmail(email);
        contactDAO.closeTransaction();
        return contact != null;
    }

    public void createContact(Contact contact) {
        contactDAO.beginTransaction();
        contactDAO.save(contact);
        contactDAO.commitAndCloseTransaction();
    }

    public List<Contact> listAll() {
        contactDAO.beginTransaction();
        List<Contact> result =contactDAO.findAll();
        contactDAO.closeTransaction();
        return result;
    }

    public void deleteContact(Contact contact) {
        contactDAO.beginTransaction();
        Contact persistedSportCategory = (Contact) contactDAO.findReferenceOnly(contact.getId());
        contactDAO.delete(persistedSportCategory);
        contactDAO.commitAndCloseTransaction();
    }

    public void updateContact(Contact contact){
        contactDAO.beginTransaction();
        Contact updatedContact = (Contact) contactDAO.find(contact.getId());
        updatedContact.setName(contact.getName());
        updatedContact.setSurname(contact.getSurname());
        updatedContact.setEmail(contact.getEmail());
        updatedContact.setMainContactCategory(contact.getMainContactCategory());
        if(contact.getMainContactCategory().getCategory().equals("business")){
            updatedContact.setBusinessContactCategory(contact.getBusinessContactCategory());
            updatedContact.setOtherContactCategory(null);
        }else if(contact.getMainContactCategory().getCategory().equals("other")){
            updatedContact.setOtherContactCategory(contact.getOtherContactCategory());
            updatedContact.setBusinessContactCategory(null);
        }else if(contact.getMainContactCategory().getCategory().equals("private")) {
            updatedContact.setBusinessContactCategory(null);
            updatedContact.setOtherContactCategory(null);
        }
        updatedContact.setPhoneNumber(contact.getPhoneNumber());
        updatedContact.setBirthdayDate(contact.getBirthdayDate());
        contactDAO.commitAndCloseTransaction();
    }
}

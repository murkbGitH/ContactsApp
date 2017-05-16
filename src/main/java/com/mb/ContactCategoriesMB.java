package com.mb;

import com.facade.ContactCategoriesFacade;
import com.model.BusinessContactCategory;
import com.model.MainContactCategory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pawel on 2017-05-12.
 */

@ManagedBean
@ViewScoped
public class ContactCategoriesMB extends AbstractMB implements Serializable{

    private ContactCategoriesFacade contactCategoriesFacade;
    private List<MainContactCategory> mainCategories;
    private List<BusinessContactCategory> businessCategories;

    public ContactCategoriesFacade getContactCategoriesFacade() {
        if(contactCategoriesFacade==null){
            contactCategoriesFacade=new ContactCategoriesFacade();
        }
        return contactCategoriesFacade;
    }

    public void setContactCategoriesFacade(ContactCategoriesFacade contactCategoriesFacade) {
        this.contactCategoriesFacade = contactCategoriesFacade;
    }

    public List<MainContactCategory> getMainCategories() {
        if(mainCategories==null){
            mainCategories=getContactCategoriesFacade().listAllMain();
        }
        return mainCategories;
    }

    public void setMainCategories(List<MainContactCategory> mainCategories) {
        this.mainCategories = mainCategories;
    }

    public List<BusinessContactCategory> getBusinessCategories() {
        if(businessCategories==null){
            businessCategories=getContactCategoriesFacade().listAllBusiness();
        }
        return businessCategories;
    }

    public void setBusinessCategories(List<BusinessContactCategory> businessCategories) {
        this.businessCategories = businessCategories;
    }
}

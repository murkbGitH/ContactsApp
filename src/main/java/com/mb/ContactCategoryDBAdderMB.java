package com.mb;

import com.model.ContactCategory;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Pawel on 2017-05-12.
 */

@ManagedBean(eager=true)
@ApplicationScoped
public class ContactCategoryDBAdderMB {

    public boolean alreadyExecuted = false;

    private String[] categoriesNames = {"służbowy", "prywatny", "inny"};

    private ContactCategory[] contactCategories = new ContactCategory[3];

    public void init(){
        if(!alreadyExecuted) {
            for(int i=0; i<categoriesNames.length;i++) {
                contactCategories[i]=new ContactCategory();
                contactCategories[i].setId(i+1);
                contactCategories[i].setCategory(categoriesNames[i]);
            }

            for(ContactCategory contactCategory:contactCategories){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactsAppUnit");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                if(em.find(ContactCategory.class,contactCategory.getId())==null) {
                    em.persist(contactCategory);
                    em.getTransaction().commit();
                }
                em.close();
                emf.close();
            }
            alreadyExecuted=true;
        }

    }

}

package com.mb;

import com.model.BusinessContactCategory;
import com.model.MainContactCategory;

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

    public boolean alreadyExecutedMain = false;
    private String[] mainCategories = {"business", "private", "other"};
    private MainContactCategory[] mainContactCategories = new MainContactCategory[3];

    public boolean alreadyExecutedBusiness = false;
    private String[] businessCategories = {"boss", "client", "co-worker"};
    private BusinessContactCategory[] businessContactCategories = new BusinessContactCategory[3];


    public void addMainContactCategories(){
        if(!alreadyExecutedMain) {
            for(int i=0; i<mainCategories.length;i++) {
                mainContactCategories[i]=new MainContactCategory();
                mainContactCategories[i].setId(i+1);
                mainContactCategories[i].setCategory(mainCategories[i]);
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactsAppUnit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            for(MainContactCategory mainContactCategory : mainContactCategories){

                if(em.find(MainContactCategory.class, mainContactCategory.getId())==null) {
                    em.persist(mainContactCategory);
                }
            }
            em.getTransaction().commit();
            em.close();
            emf.close();
            alreadyExecutedMain=true;
        }

    }

    public void addBusinessContactCategories(){
        if(!alreadyExecutedBusiness) {
            for(int i=0; i<businessCategories.length;i++) {
                businessContactCategories[i]=new BusinessContactCategory();
                businessContactCategories[i].setId(i+1);
                businessContactCategories[i].setCategory(businessCategories[i]);
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactsAppUnit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            for(BusinessContactCategory businessContactCategory : businessContactCategories){
                if(em.find(BusinessContactCategory.class, businessContactCategory.getId())==null) {
                    em.persist(businessContactCategory);

                }

            }
            em.getTransaction().commit();
            em.close();
            emf.close();
            alreadyExecutedBusiness=true;
        }

    }

}

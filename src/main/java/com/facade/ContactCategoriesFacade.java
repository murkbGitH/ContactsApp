package com.facade;

import com.dao.BusinessContactCategoryDAO;
import com.dao.MainContactCategoryDAO;
import com.model.BusinessContactCategory;
import com.model.MainContactCategory;

import java.util.List;

/**
 * Created by Pawel on 2017-05-12.
 */
public class ContactCategoriesFacade {

    private MainContactCategoryDAO mainContactCategoryDAO;
    private BusinessContactCategoryDAO businessContactCategoryDAO;

    public MainContactCategoryDAO getMainContactCategoryDAO() {
        if(mainContactCategoryDAO==null){
            mainContactCategoryDAO=new MainContactCategoryDAO();
        }
        return mainContactCategoryDAO;
    }

    public void setMainContactCategoryDAO(MainContactCategoryDAO mainContactCategoryDAO) {
        this.mainContactCategoryDAO = mainContactCategoryDAO;
    }

    public BusinessContactCategoryDAO getBusinessContactCategoryDAO() {
        if(businessContactCategoryDAO==null){
            businessContactCategoryDAO=new BusinessContactCategoryDAO();
        }
        return businessContactCategoryDAO;
    }

    public void setBusinessContactCategoryDAO(BusinessContactCategoryDAO businessContactCategoryDAO) {
        this.businessContactCategoryDAO = businessContactCategoryDAO;
    }

    public List<MainContactCategory> listAllMain() {
        getMainContactCategoryDAO().beginTransaction();
        List<MainContactCategory> result = mainContactCategoryDAO.findAll();
        mainContactCategoryDAO.closeTransaction();
        return result;
    }

    public List<BusinessContactCategory> listAllBusiness() {
        getBusinessContactCategoryDAO().beginTransaction();
        List<BusinessContactCategory> result = businessContactCategoryDAO.findAll();
        businessContactCategoryDAO.closeTransaction();
        return result;
    }

    public MainContactCategory findMainCategory(int mainCategoryId) {
        getMainContactCategoryDAO().beginTransaction();
        MainContactCategory mainContactCategory = (MainContactCategory) mainContactCategoryDAO.find(mainCategoryId);
        mainContactCategoryDAO.closeTransaction();
        return mainContactCategory;
    }

    public BusinessContactCategory findBusinessCategory(int businessCategoryId) {
        getBusinessContactCategoryDAO().beginTransaction();
        BusinessContactCategory businessContactCategory = (BusinessContactCategory) businessContactCategoryDAO.find(businessCategoryId);
        businessContactCategoryDAO.closeTransaction();
        return businessContactCategory;
    }
}

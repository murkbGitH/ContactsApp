package com.mb;

import com.facade.UserFacade;
import com.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@ManagedBean
public class LoginMB extends AbstractMB {
    @ManagedProperty(value = UserMB.INJECTION_NAME)
    private UserMB userMB;

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        UserFacade userFacade = new UserFacade();

        User user = userFacade.checkLoginData(email, password);

        if(user != null){
            userMB.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("user", user);
            return "/pages/protected/userView.xhtml?faces-redirect=true";
        }

        displayErrorMessageToUser("Check your login/password");

        return null;
    }

    public UserMB getUserMB() {
        return userMB;
    }

    public void setUserMB(UserMB userMB) {
        this.userMB = userMB;
    }

    public void resetUser(){
        userMB = new UserMB();
    }
}

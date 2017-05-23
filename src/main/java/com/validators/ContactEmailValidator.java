package com.validators;

import com.facade.ContactFacade;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Pawel on 2017-05-12.
 */
@FacesValidator("contactEmailValidator")
public class ContactEmailValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        ContactFacade contactFacade = new ContactFacade();
        if (contactFacade.emailAlreadyExists(o.toString())) {
            FacesMessage msg =
                    new FacesMessage("Email already exists",
                            "Email already exists");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}

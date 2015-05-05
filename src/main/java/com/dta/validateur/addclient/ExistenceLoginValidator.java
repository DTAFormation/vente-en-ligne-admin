package com.dta.validateur.addclient;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.dta.metier.AddClientEJB;


@ManagedBean
@RequestScoped
public class ExistenceLoginValidator implements Validator{

	private static final String LOGIN_EXISTE_DEJA = "Ce login est d�j� utilis�";
	
	@EJB
	private AddClientEJB addclientEJB;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String login = (String) arg2;
		if(addclientEJB.SearchLogin(login)){
		      throw new ValidatorException(
                      new FacesMessage( FacesMessage.SEVERITY_ERROR, LOGIN_EXISTE_DEJA, null ) );
		}
	}
}
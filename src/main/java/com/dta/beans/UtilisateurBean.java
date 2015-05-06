package com.dta.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.dta.entities.Adresse;
import com.dta.entities.Utilisateur;
import com.dta.metier.DeleteUtilisateur;
import com.dta.metier.SearchUtilisateur;


@ManagedBean
@SessionScoped
public class UtilisateurBean {
	
	@EJB
	private DeleteUtilisateur deleteUtilisateur;
	
	@EJB
	private SearchUtilisateur searchUtilisateur;
	
	public Utilisateur GetUtilisateurById(int utilisateurId) {
		return searchUtilisateur.findById(utilisateurId);
    }
	
	public List<Adresse> showAdresses(int utilisateurId) {
		Utilisateur utilisateur = searchUtilisateur.findById(utilisateurId); 
		return utilisateur.getAdresses();
    }
	
	public List<Utilisateur> getShowAll() {
		return searchUtilisateur.findAll();
    }
	
	public void delete(int utilisateurId) {
		deleteUtilisateur.delete(utilisateurId);
    }
	
}

package br.com.mario.tcc.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mario.tcc.model.Usuario;

@ManagedBean
@ViewScoped
public class ManagerUsersBean {

	private static final String PAG = "/admin/users.xhtml?faces-redirect=true";
	
	private List<Usuario> lista;
	
	public String newPage(){
		return PAG;
	}
}

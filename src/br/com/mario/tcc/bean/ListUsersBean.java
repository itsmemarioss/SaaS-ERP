package br.com.mario.tcc.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.model.Usuario;
import br.com.mario.tcc.model.UsuarioFacade;
import br.com.mario.tcc.model.UsuarioService;

@ManagedBean
@ViewScoped
public class ListUsersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8440312253349182749L;
	
	private static final String PAG = "/admin/users.xhtml?faces-redirect=true";
	
	@ManagedProperty(value = "#{contextBean}")
	private ContextBean contextBean;
	
	private UsuarioService usuarioService;
	
	private List<Usuario> list;
	
	public String newPage(){
		return PAG;
	}
	
	public ContextBean getContextBean() {
		return contextBean;
	}
	
	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
	public List<Usuario> getList() {
		if (usuarioService == null) {
			EntityManager entityManager = contextBean.getEntityManagerForTenanty();
			usuarioService = new UsuarioService(DAOFactory.createUsuaioDAOForTenant(entityManager));
		}
		
		if (list == null || list.size() == 0) {
			list = usuarioService.list();
		}
		
		return list;
	}
	
	public void setList(List<Usuario> list) {
		this.list = list;
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
package br.com.mario.tcc.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.mario.tcc.bean.ContextBean;
import br.com.mario.tcc.model.Usuario;

public class ContextoUtil {
	
	public static ContextBean getContextoBean(){
		ContextBean contextBean = null;
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		contextBean =  (ContextBean) session.getAttribute("contextBean");
		
		return contextBean;
	}
	
	public static int getTenantId(){
		return Integer.parseInt(getContextoBean().getUsuario().getEmpresa());
	}

	public static EntityManager getEntityManager(){
		return null;
	}
	
	public static void setUsuario(Usuario usuario){
		getContextoBean().setUsuario(usuario);
	}
}

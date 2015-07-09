package br.com.mario.tcc.bean;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.mario.tcc.DAO.impl.DAOUtil;
import br.com.mario.tcc.model.Usuario;
import br.com.mario.tcc.util.BuilderEntityManagerFactory;

/**
 * Classe responsável por guardar informações sobre a aplicação e o {@link Usuario} na Sessão
 * @author Mário
 *
 */

@Service
@Scope("session")
public class ContextBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8854523213990860490L;
	
	private EntityManagerFactory entityManagerFactory;
	//private EntityManager entityManagerForTenanty;
	private EntityManager entityManagerWithoutTenant;
	
	private String codigo;
	private int tenantId;

	private Usuario usuario;
	
	public Usuario getUsuario() {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		String email = externalContext.getRemoteUser();
		
		if(usuario == null || !usuario.getEmail().equals(email)){
			usuario = findUser(email);
		}*/
		
		return usuario;
	}
	
	public ContextBean() {
	}

	/**
	 * Método para recuperar o usuário a partir do email usado no loggin
	 * @return
	 */
	private Usuario findUser(String email) {
		Usuario retorno = null;
		if(email != null){
			
		}
		return retorno;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public EntityManager getEntityManagerForTenanty() {
		if(entityManagerFactory == null) 
			entityManagerFactory = BuilderEntityManagerFactory.configureEntityManagerFactory(tenantId);
		
		return entityManagerFactory.createEntityManager();
		
		//return entityManagerForTenanty;
	}

	public EntityManager getEntityManagerWithoutTenant() {
		return entityManagerWithoutTenant;
	}

	public boolean configureBean(String loging) {
		boolean retorno = false;
		entityManagerWithoutTenant = BuilderEntityManagerFactory.createEntityManagerWithoutTenant();
		DAOUtil dao = new DAOUtil(entityManagerWithoutTenant);
		tenantId = dao.tenantId(loging);
		codigo = String.valueOf(tenantId);
		entityManagerFactory = BuilderEntityManagerFactory.configureEntityManagerFactory(tenantId);
		//entityManagerForTenanty = entityManagerFactory.createEntityManager();
		retorno = true;
		return retorno;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
}
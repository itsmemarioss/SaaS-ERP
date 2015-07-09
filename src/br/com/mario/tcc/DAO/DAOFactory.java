package br.com.mario.tcc.DAO;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.mario.tcc.DAO.impl.EmpresaDAOImpl;
import br.com.mario.tcc.DAO.impl.ProdutoDAOImpl;
import br.com.mario.tcc.DAO.impl.DAOUtil;
import br.com.mario.tcc.DAO.impl.UsuarioDAOImpl;
import br.com.mario.tcc.bean.ContextBean;
import br.com.mario.tcc.model.Produto;
import br.com.mario.tcc.model.Usuario;
import br.com.mario.tcc.util.BuilderEntityManagerFactory;

public class DAOFactory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8739755246633690081L;
	
	/**
	 * Retorna um {@link UsuarioDAO} injetando o {@link EntityManager} configurado para um tenant ou não. 
	 * Essa configuração é feita a partir da flag passada por parâmetro.
	 * @param useTenant - caso true injeta o EntityManager configurado com tenant.id
	 * @return
	 */
	public GenericDAO<Usuario> createUsuarioDAO(boolean useTenant) {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		if (useTenant) {
			usuarioDAOImpl.setEntityManager(EntityManagerFactory.buildEntityManager());
		}else{
			usuarioDAOImpl.setEntityManager(EntityManagerFactory.buildEntityManager());
		}
		return usuarioDAOImpl;
	}
	
	public static DAOUtil createDAOUtil(){
		return new DAOUtil(EntityManagerFactory.buildEntityManager());
	}
	
	public static ProdutoDAOImpl createProdutoDAO(EntityManager entityManager){
		ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
		produtoDAOImpl.setEntityManager(entityManager);
		return produtoDAOImpl;
	}
	
	/**
	 * Método para criar {@link EmpresaDAOImpl}
	 * 
	 * @param entityManager ({@link EntityManager}) não configurado para uso multitenant
	 * @return
	 */
	public static EmpresaDAOImpl createEmpresaDAO(){
		EmpresaDAOImpl daoImpl = new EmpresaDAOImpl();
		daoImpl.setEntityManager(EntityManagerFactory.buildEntityManager());
		return daoImpl;
	}

	public static UsuarioDAOImpl createUsuaioDAOForTenant(int tenantId) {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		EntityManager ent =  EntityManagerFactory.buildEntityManagerForTenant(tenantId).createEntityManager();
		usuarioDAOImpl.setEntityManager(ent);
		return usuarioDAOImpl;
	}
	
	public static UsuarioDAOImpl createUsuaioDAOForTenant(EntityManager entityManager) {
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
		usuarioDAOImpl.setEntityManager(entityManager);
		return usuarioDAOImpl;
	}

}

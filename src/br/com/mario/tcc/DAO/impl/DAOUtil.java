package br.com.mario.tcc.DAO.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.mario.tcc.model.Usuario;

public class DAOUtil{

	private EntityManager entityManager;
	
	public DAOUtil(EntityManager em) {
		entityManager = em;
	}
	
	public int tenantId(String email){
		Query query = entityManager.createNativeQuery("SELECT EMPRESA_ID FROM usuario u WHERE u.email = ?1 ");
		query.setParameter(1, email);
		return  Integer.parseInt( (String) query.getSingleResult());
	}
	
	public boolean existeEmail(String email){
		Query query = entityManager.createNativeQuery("SELECT ID FROM usuario u WHERE u.email = ?1 ");
		query.setParameter(1, email);
		int id = 0;
		
		try{
			id =  (int) query.getSingleResult();
		}catch(NoResultException e){
			//nenhum retorno
		}
		
		return id > 0 ? true : false;
	}
}

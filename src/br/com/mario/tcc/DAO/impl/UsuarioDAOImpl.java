package br.com.mario.tcc.DAO.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Controller;

import br.com.mario.tcc.DAO.GenericDAO;
import br.com.mario.tcc.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl implements GenericDAO<Usuario>{

	@Override
	public void save(Usuario object) {
		try{
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

	@Override
	public void update(Usuario object) {
		try{
			em.getTransaction().begin();
			em.merge(object);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

	@Override
	public void delete(Usuario object) {
		try{
			em.getTransaction().begin();
			em.remove(object);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

	@Override
	public Usuario getById(long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> list() {
		Query query = em.createQuery("FROM Usuario u ORDER BY u.id");
		return query.getResultList();
	}

	@Override
	public List<Usuario> getByClause(String clause) {
		Query query = em.createQuery(clause);
		return query.getResultList();
	}
	
	


}

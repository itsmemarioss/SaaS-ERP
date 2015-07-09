package br.com.mario.tcc.DAO.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.mario.tcc.DAO.GenericDAO;
import br.com.mario.tcc.model.Produto;

public class ProdutoDAOImpl extends GenericDAOImpl implements GenericDAO<Produto>{

	@Override
	public void save(Produto object) {
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
	public void update(Produto object) {
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
	public void delete(Produto object) {
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
	public Produto getById(long id) {
		return null;
	}

	@Override
	public List<Produto> list() {
		Query query = em.createQuery("FROM Produto p ORDER BY p.id");
		
		return query.getResultList();
	}

	@Override
	public List<Produto> getByClause(String clause) {
		return null;
	}

}

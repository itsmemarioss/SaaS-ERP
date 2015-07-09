package br.com.mario.tcc.DAO.impl;

import java.util.List;

import br.com.mario.tcc.DAO.GenericDAO;
import br.com.mario.tcc.model.Empresa;

public class EmpresaDAOImpl extends GenericDAOImpl implements GenericDAO<Empresa> {

	@Override
	public void save(Empresa object) {
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
	public void update(Empresa object) {
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
	public void delete(Empresa object) {
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
	public Empresa getById(long id) {
		return null;
	}

	@Override
	public List<Empresa> list() {
		return null;
	}

	@Override
	public List<Empresa> getByClause(String clause) {
		return null;
	}

}

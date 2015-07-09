package br.com.mario.tcc.DAO.impl;

import javax.persistence.EntityManager;

public class GenericDAOImpl {
	
	protected EntityManager em;
	
	public void setEntityManager(EntityManager entity) {
		em = entity;
	}
}

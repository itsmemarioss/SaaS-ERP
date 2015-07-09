package br.com.mario.tcc.model;

import java.io.Serializable;

import br.com.mario.tcc.DAO.impl.DAOUtil;

public class DAOUtilService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055630254363134888L;
	
	private DAOUtil daoUtil;
	
	public DAOUtilService(DAOUtil daoUtil) {
		this.daoUtil = daoUtil;
	}
	
	public boolean existeEmail(String email){
		return daoUtil.existeEmail(email);
	}

}

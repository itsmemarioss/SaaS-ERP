package br.com.mario.tcc.model;

import java.io.Serializable;
import java.util.List;

import br.com.mario.tcc.DAO.impl.UsuarioDAOImpl;

public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8368698750250285544L;
	
	private UsuarioDAOImpl usuarioDAOImpl;

	public UsuarioDAOImpl getUsuarioDAOImpl() {
		return usuarioDAOImpl;
	}

	public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
		this.usuarioDAOImpl = usuarioDAOImpl;
	}
	
	public UsuarioService( UsuarioDAOImpl daoImpl) {
		this.usuarioDAOImpl = daoImpl;
	}
	
	public List<Usuario> list(){
		return usuarioDAOImpl.list();
	}
	
}

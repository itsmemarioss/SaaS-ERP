package br.com.mario.tcc.model;

import java.io.Serializable;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.DAO.impl.EmpresaDAOImpl;
import br.com.mario.tcc.DAO.impl.UsuarioDAOImpl;

/**
 * @author Mário
 *
 */
public class EmpresaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6840464394513920629L;
	
	private EmpresaDAOImpl empresaDAOImpl;
	
	public EmpresaDAOImpl getEmpresaDAOImpl() {
		return empresaDAOImpl;
	}

	public void setEmpresaDAOImpl(EmpresaDAOImpl empresaDAOImpl) {
		this.empresaDAOImpl = empresaDAOImpl;
	}
	
	public EmpresaService(EmpresaDAOImpl daoImpl) {
		empresaDAOImpl = daoImpl;
	}
	
	public void save(Empresa empresa){
		empresaDAOImpl.save(empresa);
	}
	
	public void save(Empresa empresa, Usuario usuario){
		empresaDAOImpl.save(empresa);
		UsuarioDAOImpl usuarioDAOImpl = DAOFactory.createUsuaioDAOForTenant(empresa.getId());
		usuarioDAOImpl.save(usuario);
	}
}

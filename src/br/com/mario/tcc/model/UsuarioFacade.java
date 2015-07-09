package br.com.mario.tcc.model;

import br.com.mario.tcc.DAO.GenericDAO;

public class UsuarioFacade {

	private GenericDAO<Usuario> usuarioDAO;
	
	/*public Usuario getUsuarioPorEmail(String email) {
		TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery("FROM Usuario u WHERE u.email = :email");
		query.setParameter("email",email);
		return query.getSingleResult();
	}*/

	
}

package br.com.mario.tcc.DAO;

import javax.persistence.EntityManager;

import br.com.mario.tcc.util.BuilderEntityManagerFactory;

/**
 * Classe responsável por criar {@link javax.persistence.EntityManager} de acordo com o solicitado
 * @author Mário
 * 
 */
public class EntityManagerFactory {


	/**
	 * Cria um {@link javax.persistence.EntityManager} que não está configurado para nenhum tenant
	 * @return {@link javax.persistence.EntityManager}
	 */
	public static EntityManager buildEntityManager(){
		return BuilderEntityManagerFactory.createEntityManagerWithoutTenant();
	}
	/**
	 * Cria um {@link javax.persistence.EntityManagerFactory} que deverá ser criado com tenant identificador passado por parâmetro
	 * @return {@link javax.persistence.EntityManagerFactory}
	 */
	public static javax.persistence.EntityManagerFactory buildEntityManagerForTenant(int tenantId){
		return BuilderEntityManagerFactory.configureEntityManagerFactory(tenantId);
	}
	
}

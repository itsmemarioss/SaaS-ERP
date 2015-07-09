package br.com.mario.tcc;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import br.com.mario.tcc.model.Funcionario;
import br.com.mario.tcc.model.Produto;

public class Teste {
	
	private static final String PERSISTENCE_UNIT_NAME = "TCC";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		String session = "sessio-500";
		
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("tenant.empresa", "500");
		properties.put(PersistenceUnitProperties.SESSION_NAME, session);
		properties.put(PersistenceUnitProperties.MULTITENANT_SHARED_EMF, "false");
	  
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,properties);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select e from Funcionario e");
		
		// create new todo
		em.getTransaction().begin();
		Produto p = new Produto();
		p.setDescricao("Produto teste pooorra");
		em.persist(p);

		em.getTransaction().commit();
		em.close();
  }
}
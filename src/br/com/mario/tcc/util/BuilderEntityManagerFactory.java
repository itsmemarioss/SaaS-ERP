package br.com.mario.tcc.util;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class BuilderEntityManagerFactory {
	
	private static final String PERSISTENCE_UNIT_NAME = "TCC";
	
	public static EntityManagerFactory configureEntityManagerFactory(Integer tenantId){
		String tenant = String.valueOf(tenantId);
		String session = "sessio-"+tenant;
		
		EntityManagerFactory entityManagerFactory;
		
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("tenant.empresa", tenant );
		properties.put(PersistenceUnitProperties.SESSION_NAME, session);
		properties.put(PersistenceUnitProperties.MULTITENANT_SHARED_EMF, "false");
	  
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,properties);
		return entityManagerFactory;
	}
	
	public static EntityManager createEntityManagerWithoutTenant(){
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
}

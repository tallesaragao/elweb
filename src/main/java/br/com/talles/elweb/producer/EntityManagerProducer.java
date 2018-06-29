package br.com.talles.elweb.producer;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		Map<String, String> persistenceOptions = getPersistenceOptions();
		if(persistenceOptions == null) {
			factory = Persistence.createEntityManagerFactory("elweb");
		}
		else {
			factory = Persistence.createEntityManagerFactory("elweb", persistenceOptions);			
		}
	}
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}
	
	private Map<String, String> getPersistenceOptions() {
		String env = System.getenv("MYSQLCONNSTR_localdb");
		if(env == null || env.isEmpty()) {
			return null;
		}
		
		String database = null;
		String dataSource = null;
		String userId = null;
		String password = null;
		String url = null;
		
		String[] parametros = env.split(";");
		for(String parametro : parametros) {
			if(parametro.contains("Database=")) {
				database = parametro.replace("Database=", "");
			}
			if(parametro.contains("Data Source=")) {
				dataSource = parametro.replace("Data Source=", "");
			}
			if(parametro.contains("User Id=")) {
				userId = parametro.replace("User Id=", "");
			}
			if(parametro.contains("Password=")) {
				password = parametro.replace("Password=", "");
			}
		}
		
		url = "jdbc:mysql://" + dataSource + "/" + database;
		
		Map<String, String> persistenceOptions = new HashMap<>();
		if(url != null) {
			persistenceOptions.put("javax.persistence.jdbc.url", url);
		}
		if(userId != null) {
			persistenceOptions.put("javax.persistence.jdbc.user", userId);
		}
		if(password != null) {
			persistenceOptions.put("javax.persistence.jdbc.password", password);
		}
		if(persistenceOptions.isEmpty()) {
			return null;
		}
		return persistenceOptions;
	}
}

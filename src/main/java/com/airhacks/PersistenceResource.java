package com.airhacks;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

@ApplicationScoped
public class PersistenceResource {

	
	public PersistenceResource() {
		// TODO Auto-generated constructor stub

		/*
		 * try { InitialContext context = new InitialContext();
		 * 
		 * this.pmf = (PersistenceManagerFactory) context.lookup("java:/TraderDB-PU");
		 * System.out.println(pmf.toString()); } catch (NamingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@Produces
	@RequestScoped
	public PersistenceManager getPersistenceManager() {
		System.out.println("BURADA!");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("java:/datanucleus");

		System.out.println(pmf.toString());

		return pmf.getPersistenceManager();

	}

	/*
	 * public void close(@Disposes @Default PersistenceManager pm ){ pm.close(); }
	 */

}

package com.airhacks;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserResource {

	@Inject
	PersistenceManager pm;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Kullanıcı getUser() {
		// Create a new instance of Kullanıcı

		Kullanıcı user = new Kullanıcı();

		// Set properties of the user
		user.setOluşturmaTarihi(new Date());
		user.setDeğiştirmeTarihi(new Date());
		user.setHakkımda("Some description");
		user.setMeslek("Some job title");
		user.setProfilResmiUrl("http://example.com/profile.jpg");
		user.setId(1); // Or whatever unique ID you want to assign
		user.setKullanıcıAdı("username");
		user.setKullanıcıSoyadı("lastname");
		user.seteMail("email@example.com");
		user.setSistemeKullanıcıYerleştirmedeYetkili(true);
		user.setYönetici(false);
		try {
			Kullanıcı kullanıcı = pm.makePersistent(user);
			return kullanıcı;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HATA ULAN HATA: " + e.getMessage());
		}
		return null;
	}
}

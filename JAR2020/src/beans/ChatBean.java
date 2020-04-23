package beans;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.annotation.*;
import beans.Korisnik;
import javax.ws.rs.core.Response;
import services.userServices;




@Stateless
@Path("/chat")
@LocalBean

public class ChatBean {
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		
		
			return "OK";
	
		
	}
	
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String testform(@FormParam("ime") String ime, @FormParam("sifra") String sifra) {
		Korisnik k = new Korisnik(ime, sifra);
		userServices us = new userServices();
		us.dodajRegistrovanog(k);
		
		
		
		return "Uspjesna registracija!";
	}
	

}

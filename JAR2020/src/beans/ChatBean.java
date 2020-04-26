package beans;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import java.util.ArrayList;

import javax.annotation.*;
import beans.Korisnik;
import javax.ws.rs.core.Response;
import services.userServices;




@Stateless
@Path("/chat")
@LocalBean

public class ChatBean {
	
	@EJB userServices us;
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
			if(us.regPrazno() == false && us.logPrazno() == false)
			{
				return "ok";
			}
			else return " notok";
		
	}
	
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String register(@FormParam("ime") String ime, @FormParam("sifra") String sifra) {
		 
		Korisnik k = new Korisnik(ime, sifra);
		if(us.regPostoji(k) == false) {
			us.dodajReg(k);
			return "Registracia uspjesna";
			
		}
		
		
		else return "Korisncko me postoji";
		
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("ime") String ime, @FormParam("sifra") String sifra) {
			
			Korisnik k = new Korisnik(ime, sifra);
			if(us.regPostoji(k) == false)
			{
				return "Korisnicko ime ne postoji, molim vas registrujte se";
						
			}
			else
			{
				us.dodajLog(k);
				return "uspjesno logovanje";
				
			}
		
		
		
		
			
		}
	
	@GET
	@Path("/listLog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listLog()
	{
		return Response
				.ok(us.listaLogovanih())
				.build();
	}
	
	@GET
	@Path("/listReg")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listReg()
	{
		return Response
				.ok(us.listaRegistrovanih())
				.build();
	}
	
	
	}
	
	
	
	



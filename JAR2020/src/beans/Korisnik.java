package beans;

import javax.ws.rs.FormParam;


public class Korisnik {
	@FormParam("ime")
	private String ime;
	@FormParam("sifra")
	private String sifra;
	
	
	public Korisnik() {
		
	}
	
	public Korisnik(String ime, String sifra)
	{
		this();
		this.ime = ime;
		this.sifra = sifra;
		
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra)
	{
		this.sifra = sifra;
	}
	
	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", sifra=" + sifra + "]";
	}
	
	

}

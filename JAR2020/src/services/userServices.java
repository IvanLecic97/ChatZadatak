package services;




import java.util.ArrayList;

import java.util.List;


import beans.Korisnik;
public class userServices {

	private List<Korisnik> registrovaniKorisnici = new ArrayList<>();
	private List<Korisnik> prijavljeniKorisnici = new ArrayList<>();
	
	
	public userServices() 
	{
		
	}
	
	public void dodajRegistrovanog(Korisnik k)
	{
		registrovaniKorisnici.add(k);
		
	}
	public void ukloniRegistrovanog(Korisnik k)
	{
		int num = registrovaniKorisnici.indexOf(k);
		registrovaniKorisnici.remove(num);
	}
	
	public void dodajLogovanog(Korisnik k)
	{
		prijavljeniKorisnici.add(k);
	}
	
	public void ukloniLogovanog(Korisnik k)
	{
		int num = prijavljeniKorisnici.indexOf(k);
		prijavljeniKorisnici.remove(num);
	}
	
	public boolean provjeraLogovanog(Korisnik k)
	{
		if(prijavljeniKorisnici.contains(k) == true)
		{
			return true;
			
		}
		
		
		return false;
	}
	
	
	public void prikaziRegistrovane()
	{
		
		for(Korisnik k : registrovaniKorisnici)
		{
			System.out.println(k.getIme());
			
		}
	}
	
	public boolean regPrazno()
	{
		if(registrovaniKorisnici.isEmpty() == true)
		{
			return true;
		}
		else
		return false;
			
		
	}
	
	
	
	
	
}



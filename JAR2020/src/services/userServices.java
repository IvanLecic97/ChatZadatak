package services;




import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

import beans.Korisnik;

@Singleton
public class userServices {
	
	private HashMap<String, Korisnik> regKorisnici = new HashMap<String, Korisnik>();
	private HashMap<String, Korisnik> logKorisnici = new HashMap<String, Korisnik>();

	
	public userServices()
	{
		
	}
	
	public void dodajReg(Korisnik k)
	{
		regKorisnici.put(k.getIme(), k);
	}
	
	public void dodajLog(Korisnik k)
	{
		logKorisnici.put(k.getIme(), k);
	}
	
	public boolean regPrazno()
	{
		if(regKorisnici.isEmpty() == true)
		{
			return true;
		}
		else return false;
	}
	
	public boolean regPostoji(Korisnik k)
	{
		if(regKorisnici.containsKey(k.getIme()))
		{
			return true;
		}
		else return false;
	}
	
	public boolean logPrazno()
	{
		if(logKorisnici.isEmpty() == true)
		{
			return true;
		}
		else return false;
	}
	
	public ArrayList listaLogovanih()
	{
		ArrayList<String> lista = new ArrayList<>();
		for(String s  : logKorisnici.keySet())
		{
			lista.add(s);
			
		}
		return lista;
		
	}
	
	public ArrayList listaRegistrovanih()
	{
		ArrayList<String> lista = new ArrayList<>();
		for(String s  : regKorisnici.keySet())
		{
			lista.add(s);
			
		}
		return lista;
		
	}
	
}



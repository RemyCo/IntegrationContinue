package com.blo;

import java.util.ArrayList;

import com.dto.City;

public interface VilleBLO {

	public ArrayList<City> getInfoVilles(String codePostal);
	
	public void insertVille(City ville);
	
	public void updateVille(String codePostal, City ville);

}

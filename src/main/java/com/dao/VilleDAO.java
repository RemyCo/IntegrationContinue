package com.dao;

import java.util.ArrayList;

import com.dto.City;

public interface VilleDAO {
	
	public ArrayList<City> findAllVilles();

    public ArrayList<City> findVilleByCodePostal(String postalCode);

	public void saveCity(City city);
	
	public void updateCity(String postalCode, City city);
}

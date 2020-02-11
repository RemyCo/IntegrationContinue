package com.blo;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.City;

@Slf4j
@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	@Override
	public ArrayList<City> getInfoVilles(String codePostal) {
		ArrayList<City> listVille;
		
        if (codePostal == null || "".equalsIgnoreCase(codePostal)) {
			listVille = villeDAO.findAllVilles();
		} else {
			listVille = villeDAO.findVilleByCodePostal(codePostal);
		}
        
		
		return listVille;
	}
	
	@Override
	public void insertVille(City ville) {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.saveCity(ville);
		} 
		
	}
	
	@Override
	public void updateVille(String codePostal, City ville) {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.updateCity(codePostal, ville);
		}
	}
	
	
}

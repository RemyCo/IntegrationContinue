package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.dto.Coordinate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {	
	
	/**
	 * Serial IUD for serialization.
	 */
	private static final long serialVersionUID = -8050478362033217382L;
	
	private String communeCode;
	private String communeName;
	private String postalCode;
	private String libelleAcheminement;	
	private String ligne;	
	private Coordinate coordinate;
	
	
	public String getCodeCommune() {
		return communeCode;
	}
	
	public void setCodeCommune(String codeCommune) {
		this.communeCode = codeCommune;
	}
	
	public String getNomCommune() {
		return communeName;
	}
	
	public void setNomCommune(String nomCommune) {
		this.communeName = nomCommune;
	}
	
	public String getCodePostal() {
		return postalCode;
	}
	
	public void setCodePostal(String codePostal) {
		this.postalCode = codePostal;
	}
	
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	
	public String getLigne() {
		return ligne;
	}
	
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	
	public Coordinate getCoordonnee() {
		return coordinate;
	}
	
	public void setCoordonnee(Coordinate coordonnee) {
		this.coordinate = coordonnee;
	}	

}

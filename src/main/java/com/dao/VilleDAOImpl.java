package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.Coordinate;
import com.dto.City;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	@Override
	public ArrayList<City> findAllVilles() {
		ArrayList<City> listVille = new ArrayList<City>();

		try {
			
			Connection con = JDBCConfigurationSol1.getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ville_france");
			
			
			while(resultSet.next()){
				City ville = new City();
				
				ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne(resultSet.getString("Ligne_5"));
				Coordinate coordonnee = new Coordinate();
				coordonnee.setLatitude(resultSet.getString("Latitude"));
				coordonnee.setLongitude(resultSet.getString("Longitude"));
				ville.setCoordonnee(coordonnee);

				listVille.add(ville);
			}
			
			resultSet.close();
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listVille;
            
    }
	
	@Override
	public ArrayList<City> findVilleByCodePostal(String codePostal) {
		ArrayList<City> listVille = new ArrayList<City>();

		try {
			Connection con = JDBCConfigurationSol1.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ville_france where Code_postal = ?");
			statement.setString(1, codePostal);
            ResultSet resultSet = statement.executeQuery();

            
			while(resultSet.next()){
				City ville = new City();
				
				ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne(resultSet.getString("Ligne_5"));
				Coordinate coordonnee = new Coordinate();
				coordonnee.setLatitude(resultSet.getString("Latitude"));
				coordonnee.setLongitude(resultSet.getString("Longitude"));
				ville.setCoordonnee(coordonnee);
  
				listVille.add(ville);
			}
			
			resultSet.close();
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listVille;
            
    }
	
	@Override
    public void saveCity(City ville) {

		try {
			Connection con = JDBCConfigurationSol1.getConnection();
			String insertTableSQL = "INSERT INTO ville_france "
					+ "(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) "
					+ "VALUES (?,?,?,?,?,?,?) ";
			
			PreparedStatement statement = con.prepareStatement(insertTableSQL);
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, ville.getCodePostal());
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getLigne());
			statement.setString(6, ville.getCoordonnee().getLatitude());
			statement.setString(7, ville.getCoordonnee().getLongitude());
            statement.executeUpdate();
            
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
            
    }
	
	@Override
    public void updateCity(String codePostal, City ville) {

		try {
			Connection con = JDBCConfigurationSol1.getConnection();
			
			String updateTableSQL = "UPDATE ville_france SET "
					+ "Code_commune_INSEE = ?, Nom_commune = ?, Code_postal = ?, Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ? "
					+ "WHERE Code_postal = ? ";
			
			PreparedStatement statement = con.prepareStatement(updateTableSQL);
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, codePostal);
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getLigne());
			statement.setString(6, ville.getCoordonnee().getLatitude());
			statement.setString(7, ville.getCoordonnee().getLongitude());
			statement.setString(8, codePostal);
            statement.executeUpdate();
            
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
            
    }
}

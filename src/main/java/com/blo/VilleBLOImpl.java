package com.blo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.VilleDAO;
import com.dto.Ville;

public class VilleBLOImpl implements VilleBLO {
	
	Logger logger = Logger.getLogger("logger");
	
	@Autowired
	private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVilles(String codePostal) throws VilleException {
		// TODO Auto-generated method stub

		ArrayList<Ville> listVille;
		
		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des informations
        if (codePostal == null || "".equalsIgnoreCase(codePostal)) {
			listVille = villeDAO.findAllVilles();
		} else {
			listVille = villeDAO.findVilleByCodePostal(codePostal);
		}
        
		logger.log(Level.INFO, "Nombre de ville récupérée(s) : " + listVille.size() );
		
		return listVille;
	}

	@Override
	public void insertVille(Ville ville) throws VilleException {
		// TODO Auto-generated method stub
		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.saveVille(ville);
		} 
		// exemple de gestion des erreurs
		/*} catch (Exception e) {
			log.error("Impossible d'ajouter le message", e);
			throw new TchatException("ERREUR_INCONNUE");
		}*/
	}

	@Override
	public void updateVille(String codePostal, Ville ville) throws VilleException {
		// TODO Auto-generated method stub
		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.updateVille(codePostal, ville);
		} 
		// exemple de gestion des erreurs
		/*} catch (Exception e) {
			log.error("Impossible d'ajouter le message", e);
			throw new TchatException("ERREUR_INCONNUE");
		}*/
	}
	

}

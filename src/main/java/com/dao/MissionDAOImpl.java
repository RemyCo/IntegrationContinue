package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.LieuMission;
import com.dto.Mission;

@Repository
public class MissionDAOImpl implements MissionDAO {

	@Override
	public ArrayList<Mission> findAllTrains() {
		ArrayList<Mission> listMission = new ArrayList<Mission>();

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			// solution 2
			// Connection con = JDBCConfigurationSol2.getConnection();
			Statement statement = con.createStatement();

			// execute la requete
			ResultSet resultSet = statement.executeQuery("SELECT * FROM info_train");

			// parcourt des éléments de réponse
			while (resultSet.next()) {
				Mission villes = new Mission();

				villes.setId(resultSet.getInt("id"));
				villes.setNumeroTrain(resultSet.getString("numero"));
				villes.setDateCirculation(resultSet.getString("dateCirculation"));
				villes.setHoraireDepart(resultSet.getString("horaireDepart"));
				villes.setHoraireDestination(resultSet.getString("horaireDestination"));
				LieuMission lieuMissionOrigine = new LieuMission();
				lieuMissionOrigine.setUIC(resultSet.getString("lieuOrigineUIC"));
				lieuMissionOrigine.setLibPr(resultSet.getString("lieuOrigineLibPr"));
				villes.setLieuOrigine(lieuMissionOrigine);
				LieuMission lieuMissionDestination = new LieuMission();
				lieuMissionDestination.setUIC(resultSet.getString("lieuDestinationUIC"));
				lieuMissionDestination.setLibPr(resultSet.getString("lieuDestinationLibPr"));
				villes.setLieuDestination(lieuMissionDestination);

				listMission.add(villes);
			}

			// close de la connexion
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMission;

	}

}

package com.controller;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
class VilleController {
	
	Logger logger = Logger.getLogger("logger");
	
	@Autowired
	VilleBLO villeService;

	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> recover(@RequestParam(required = false, value="codePostal") String codePostal) {
		//log.info("Appel GET");

		ArrayList<Ville> listVille =  villeService.getInfoVilles(codePostal);
		return listVille;
	}
	
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Ville ville, Model model) {
	//public String insert(@RequestBody String num) {
	    //System.out.println(num);
		logger.log(Level.INFO, "Appel POST");
		logger.log(Level.INFO, "ville Post : " + ville.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(ville);
			//log.info("ville Json : " + jsonInString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    villeService.insertVille(ville);
		return "index";
	}
	
	@RequestMapping(value="/ville/{codePostal}", method=RequestMethod.PUT)
	@ResponseBody
	//public String connexion(@RequestBody String num) {
	public String update(@PathVariable String codePostal, @RequestBody Ville ville, Model model) {
		//log.info("Appel PUT");

	    System.out.println(codePostal);
	    System.out.println(ville.getCodePostal());
	    villeService.updateVille(codePostal, ville);
		return "index";
	}
}
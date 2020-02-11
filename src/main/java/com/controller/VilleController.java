package com.controller;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

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
import com.dto.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
class VilleController {
	
	@Autowired
	VilleBLO villeService;

	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<City> recover(@RequestParam(required = false, value="codePostal") String codePostal) {

		ArrayList<City> listVille =  villeService.getInfoVilles(codePostal);
		return listVille;
	}
	
	
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody City ville, Model model) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(ville);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}

	    villeService.insertVille(ville);
		return "index";
	}
	
	@RequestMapping(value="/ville/{codePostal}", method=RequestMethod.PUT)
	@ResponseBody
	
	public String update(@PathVariable String codePostal, @RequestBody City ville, Model model) {

	    System.out.println(codePostal);
	    villeService.updateVille(codePostal, ville);
		return "index";
	}
}

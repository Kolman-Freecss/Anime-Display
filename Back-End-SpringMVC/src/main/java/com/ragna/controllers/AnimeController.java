package com.ragna.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragna.models.Anime;
import com.ragna.services.AnimeService;

@RestController
@RequestMapping("/anime-display/api/anime")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
//@CrossOrigin(origins = "http://localhost:4200")
public class AnimeController {

	@Autowired
	private AnimeService animeService;
	
	@PostMapping(value="/createAnime")
	private ResponseEntity<?> createAnime(@RequestBody Anime anime) {
		try {
			this.animeService.createAnime(anime);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not working");
		}
		return ResponseEntity.ok().body("Anime has been created succesfully");
	}
	
	@GetMapping(value = "/getAnimes")
	private ResponseEntity<List<Anime>> getAnime() {

		List<Anime> response = null;
		try {
			response = this.animeService.getAnimes();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

		return response == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<List<Anime>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getAnimeById/{idAnime}")
	private ResponseEntity<Anime> getAnimeById(@PathVariable("idAnime") int idAnime) {

		Anime response = null;
		try {
			response = this.animeService.getAnime(idAnime);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return response == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<Anime>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/updateAnime/{dni}")
	private ResponseEntity<?> updateAnime(@PathVariable("dni") String dni, @RequestBody Anime anime) {

		try {
			this.animeService.updateAnime(anime);
		}catch(IOException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().body("Anime has been updated succesfully");
	}
	
	@DeleteMapping("/deleteAnime/{id}")
	public ResponseEntity<?> deleteAnime(@PathVariable("id") int id) {
		
		try {
		this.animeService.deleteAnime(id);
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body("Anime has been deleted successfully.");
	}
	
}

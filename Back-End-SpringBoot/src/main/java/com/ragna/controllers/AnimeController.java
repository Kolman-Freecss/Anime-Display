package com.ragna.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ragna.pojos.animation.Anime;
import com.ragna.service.AnimeService;
import com.ragna.utils.pdf.PDF;
import com.ragna.utils.pdf.PDFGenerator;

@RestController
@RequestMapping("/anime-display/api/anime")
public class AnimeController
{

	@Autowired
	private AnimeService animeService;

	private ObjectMapper mp = new ObjectMapper();

	@PostMapping(value = "/createAnime")
	private ResponseEntity<?> createAnime(@RequestBody Anime anime)
	{
		try
		{
			this.animeService.createAnime(anime);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getAnimes")
	private ResponseEntity<List<Anime>> getAnime()
	{

		List<Anime> response = null;
		try
		{
			response = this.animeService.getAnimes();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return response == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getAnimeById/{idAnime}")
	private ResponseEntity<Anime> getAnimeById(@PathVariable("idAnime") int idAnime)
	{

		Anime response = null;
		try
		{
			response = this.animeService.getAnime(idAnime);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return response == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/updateAnime")
	private ResponseEntity<?> updateAnime(@RequestBody Anime anime)
	{

		try
		{
			this.animeService.updateAnime(anime);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAnime/{id}")
	public ResponseEntity<?> deleteAnime(@PathVariable("id") int id)
	{

		try
		{
			this.animeService.deleteAnime(id);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/exportPdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> exportPdfAnime(@RequestBody String animes) throws IOException
	{
		List<Anime> animeList = this.mp.readValue(animes, new TypeReference<List<Anime>>() {
		});
		
		PDF<Anime> pdf = new PDFGenerator<>();

		ByteArrayInputStream bis = pdf.buildPDF(animeList);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=animes.pdf");
		headers.setContentType(MediaType.APPLICATION_PDF);

		return new ResponseEntity<>(new InputStreamResource(bis), headers, HttpStatus.OK);
	}

}

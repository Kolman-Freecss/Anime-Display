package com.ragna.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ragna.models.Anime;

@Repository
public class AnimeDAOImpl implements AnimeDAO {

	@Value("${path.file.anime}")
	private String pathFile; 
	
	private File file = new File(pathFile);
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void createAnime(Anime anime) throws IOException {
		List<Anime> animeList = this.getAnimes();
		animeList.add(anime);
		this.saveAnimes(animeList);
	}

	@Override
	public Anime getAnime(int id) throws IOException{
		List<Anime> animeList = this.getAnimes();
		Anime animeReturn = new Anime(); 
		for(Anime a : animeList) {
			if(a.getId() == id) {
				animeReturn = a;
				break;
			}
		}
		return animeReturn;
	}

	@Override
	public void updateAnime(Anime anime) throws IOException{
		List<Anime> animeList = this.getAnimes();
		Anime animeToDelete = new Anime(); 
		for(Anime a : animeList) {
			if(a.getId() == anime.getId()) {
				animeToDelete = a;
				break;
			}
		}
		animeToDelete = anime;
		animeList.remove(animeToDelete);
		animeList.add(anime.getId(), anime);
		this.saveAnimes(animeList);
	}

	@Override
	public void deleteAnime(int id) throws IOException{
		List<Anime> animeList = this.getAnimes();
		for(Anime a : animeList) {
			if(a.getId() == id) {
				animeList.remove(a);
				break;
			}
		}
	}
	
	@Override
	public void saveAnimes(List<Anime> animeList) throws IOException {
		this.mapper.writeValue(file, animeList);
	}

	@Override
	public List<Anime> getAnimes() throws IOException {
		
		List<Anime> animeList = this.mapper.readValue(this.file, List.class);
		return animeList;
	}

}

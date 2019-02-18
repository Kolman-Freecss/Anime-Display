package com.ragna.dao;

import java.util.List;

import com.ragna.models.Anime;

public interface AnimeDAO {

	/* CRUD */
	
	public void createAnime(Anime anime);
	public Anime getAnime(int id);
	public void updateAnime(Anime anime);
	public void deleteAnime(int id);
	
	public List<Anime> getAnimes();
	
	
}

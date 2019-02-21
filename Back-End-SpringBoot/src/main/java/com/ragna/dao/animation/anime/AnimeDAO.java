package com.ragna.dao.animation.anime;

import java.io.IOException;
import java.util.List;

import com.ragna.pojos.animation.Anime;

public interface AnimeDAO {

	/* CRUD */
	
	public void createAnime(Anime anime) throws IOException;
	public Anime getAnime(int id) throws IOException;
	public void updateAnime(Anime anime) throws IOException;
	public void deleteAnime(int id) throws IOException;
	
	public void saveAnimes(List<Anime> animeList) throws IOException;
	public List<Anime> getAnimes() throws IOException;
	
	
}

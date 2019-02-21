package com.ragna.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragna.dao.animation.anime.AnimeDAO;
import com.ragna.pojos.animation.Anime;

@Service
public class AnimeService {

	@Autowired
	private AnimeDAO animeDao;
	
	public void createAnime(Anime anime) throws IOException {
		this.animeDao.createAnime(anime);
	}

	public Anime getAnime(int id) throws IOException {
		return this.animeDao.getAnime(id);
	}

	public void updateAnime(Anime anime) throws IOException {
		this.animeDao.updateAnime(anime);
	}

	public void deleteAnime(int id) throws IOException {
		this.animeDao.deleteAnime(id);
	}

	public List<Anime> getAnimes() throws IOException {
		return this.animeDao.getAnimes();
	}
	
}

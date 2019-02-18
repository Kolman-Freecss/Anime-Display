package com.ragna.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragna.dao.AnimeDAO;
import com.ragna.models.Anime;

@Service
public class AnimeService {

	@Autowired
	private AnimeDAO animeDao;
	
	public void createAnime(Anime anime) {
		this.animeDao.createAnime(anime);
	}

	public Anime getAnime(int id) {
		return this.animeDao.getAnime(id);
	}

	public void updateAnime(Anime anime) {
		this.animeDao.updateAnime(anime);
	}

	public void deleteAnime(int id) {
		this.animeDao.deleteAnime(id);
	}

	public List<Anime> getAnimes() {
		return this.animeDao.getAnimes();
	}
	
}

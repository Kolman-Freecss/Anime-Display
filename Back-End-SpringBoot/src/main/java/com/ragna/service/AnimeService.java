package com.ragna.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ragna.pojos.animation.Anime;

@Service
public interface AnimeService
{

	public void createAnime(Anime anime) throws IOException;
	public Anime getAnime(int id) throws IOException;
	public void updateAnime(Anime anime) throws IOException;
	public void deleteAnime(int id) throws IOException;
	public List<Anime> getAnimes() throws IOException;

}

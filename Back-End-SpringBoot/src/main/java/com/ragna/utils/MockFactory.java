package com.ragna.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ragna.pojos.Anime;
import com.ragna.pojos.Anime.Gender;

public class MockFactory {

	private static int currentIdAnime = 0;

	public static List<Anime> animeList = new ArrayList<>();

	static {
		animeList.addAll(Arrays.asList(
				new Anime(animeList.size()+1, "Bleach", Gender.ACTION, "http://www.jkanime.com/bleach", true),
				new Anime(animeList.size()+1, "Boku No Hero", Gender.ACTION, "http://www.jkanime.com/BokuNoHero", false),
				new Anime(animeList.size()+1, "Black Clover", Gender.ACTION, "http://www.jkanime.com/BlackClover", false)
				)
			);
	}

	private MockFactory() {
		throw new IllegalStateException("Utility class");
	}

	public static Object createObject(Class<?> cls) {
		Object objectResponse = null;
		if(cls == Anime.class) {
			objectResponse = new Anime(currentIdAnime); 
			currentIdAnime++;
		}
		return objectResponse;
	}

}

package com.ragna.pojos.animation;

import com.ragna.pojos.Gender;

public class Anime extends AnimationShow {
	
	public Anime(int id, String name, Gender gender, String website, boolean isFinished) {
		super(id, name, gender, website, isFinished);
	}

	public Anime(int id) {
		super(id);
	}

	public Anime() {
		super();
	}
	
}

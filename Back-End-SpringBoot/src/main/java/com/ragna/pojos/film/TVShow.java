package com.ragna.pojos.film;

import com.ragna.pojos.Gender;
import com.ragna.pojos.MotionPicture;

public abstract class TVShow extends MotionPicture {
	
	private String canal;
	
	public TVShow(int id, String name, Gender gender, String website, boolean isFinished, String canal) {
		super(id, name, gender, website, isFinished);
		this.canal = canal;
	}

	public String getCanal()
	{
		return canal;
	}

	public void setCanal(String canal)
	{
		this.canal = canal;
	}
	
}

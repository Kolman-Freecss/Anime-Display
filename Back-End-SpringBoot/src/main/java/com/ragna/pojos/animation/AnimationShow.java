package com.ragna.pojos.animation;

import com.ragna.pojos.Gender;

public abstract class AnimationShow {
	
	private int id;
	private String name;
	private Gender gender;
	private String website;
	private boolean isFinished;
	
	public AnimationShow(int id, String name, Gender gender, String website, boolean isFinished) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.website = website;
		this.isFinished = isFinished;
	}
	
	public AnimationShow(int id) {
		this.id = id;
	}
	
	public AnimationShow() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
}

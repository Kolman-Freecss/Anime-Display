package com.ragna.pojos.animation;

import com.ragna.pojos.Gender;
import com.ragna.pojos.MotionPicture;

public abstract class AnimationShow extends MotionPicture
{

	public AnimationShow(int id, String name, Gender gender, String website, boolean isFinished)
	{
		super(id, name, gender, website, isFinished);
	}

	public AnimationShow(int id)
	{
		super(id);
	}
	
	public AnimationShow()
	{
	}
	
}

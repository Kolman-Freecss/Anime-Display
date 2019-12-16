package com.ragna.utils.pdf;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ragna.pojos.MotionPicture;

/**
 * A PDF builder that have some instances with different styles of PDF
 * */
public interface PDF<T extends MotionPicture>
{

	public abstract ByteArrayInputStream buildPDF(List<T> list);
	
}

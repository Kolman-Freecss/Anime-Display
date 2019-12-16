package com.ragna.utils.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ragna.pojos.MotionPicture;

public class PDFGenerator<T extends MotionPicture> implements PDF<T>{

	public PDFGenerator() 
	{
		// He do nothing because he not have any property.
	}
	
	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
	
	@Override
	public ByteArrayInputStream buildPDF(List<T> list) {
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			PdfWriter.getInstance(document, out);
			document.open();
			
			// Add Text to PDF file ->
        	Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
        	Paragraph para = new Paragraph( "Customized table", font);
        	para.setAlignment(Element.ALIGN_CENTER);
        	document.add(para);
        	document.add(Chunk.NEWLINE);
        	
        	PdfPTable table = new PdfPTable(3);
        	
        	// Add PDF Table Header ->
            Stream.of("ID", "Name", "Gender")
	            .forEach(headerTitle -> {
		              PdfPCell header = new PdfPCell();
		              Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		              header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		              header.setHorizontalAlignment(Element.ALIGN_CENTER);
		              header.setBorderWidth(2);
		              header.setPhrase(new Phrase(headerTitle, headFont));
		              table.addCell(header);
	            });
            
            list.forEach(anime -> {
            	table.addCell(newCell(String.valueOf(anime.getId()), Element.ALIGN_CENTER, false));
                table.addCell(newCell(anime.getName(), Element.ALIGN_LEFT, false));
                table.addCell(newCell(String.valueOf(anime.getGender()), Element.ALIGN_RIGHT, true));
            });
            
            document.add(table);
            
            document.close();
			
		} catch (Exception e) {
			logger.error(e.toString());
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}

	private static PdfPCell newCell(String valueCell, int horizontalAligment, boolean isLastCell)
	{
		PdfPCell idCell = new PdfPCell(new Phrase(valueCell));
		if(isLastCell)
			idCell.setPaddingRight(4);
		else
			idCell.setPaddingLeft(4);
		idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		idCell.setHorizontalAlignment(horizontalAligment);
		return idCell;
	}
	
}

package com.techtree.ttshoppingcart.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ObjecToExcel{

	public static ByteArrayInputStream objectoExcel(List<Object[]> list ) throws IOException{
	
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MMM-Y hh:mm:ss");
	String [] columns ={"trancantionDateTime","OrderTime","amount","discount","paidAmount","item_name","Qntitiy","Fname","Lname"};
	
	try(
	Workbook workbook = new XSSFWorkbook();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	){
	Sheet sheet= workbook.createSheet("Students");
	Font headerFont = workbook.createFont();
	headerFont.setBold(true);
	headerFont.setColor(IndexedColors.BLUE.getIndex());
	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setFont(headerFont);
	// Row for Header -->
	Row headerRow =sheet.createRow(0);
	// Header
	
	
	for(int col=0; col<columns.length; col++)
	{
	Cell cell =headerRow.createCell(col);
	cell.setCellValue(columns[col]);
	cell.setCellStyle(headerCellStyle);
	}
	int rowidx=1;

	List<Object[]> Object =list;
//	for( Object[] obj:Object) {
	
//	 [
//"2022-08-25T12:46:21.000+00:00",
//"2022-08-20T07:30:27.000+00:00",
//1500.0,
//50.0,
//1450.0,
//"pant",
//3,
//"prasanna",
//"acharya"
//],
		for(int i=0;i<Object.size();i++) {
			 Object[] obj=Object.get(i);
		Row row = sheet.createRow(rowidx++);
		String Date = dateformatter.format((Date) obj[0]);
		row.createCell(0).setCellValue(Date);
		String Date1 = dateformatter.format((Date) obj[1]);
		row.createCell(1).setCellValue(Date1);
		row.createCell(2).setCellValue((double)obj[2]);
		row.createCell(3).setCellValue((double)obj[3]);
		row.createCell(4).setCellValue((double)obj[4]);
		row.createCell(5).setCellValue(obj[5].toString());
		row.createCell(6).setCellValue((int)obj[6]);
		row.createCell(7).setCellValue(obj[7].toString());
		row.createCell(8).setCellValue(obj[8].toString());
//		row.createCell(9).setCellValue(obj[9].toString());
		workbook.write(out);
	}	
		return new ByteArrayInputStream(out.toByteArray());
		
		
	
	}
	}

}

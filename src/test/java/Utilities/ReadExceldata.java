package Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExceldata {
	
	String url = System.getProperty("user.dir")+"//src//test//resources//Logindatadriven.xlsx";
	public int rowCount() throws IOException {
		
		InputStream fis = new FileInputStream(url);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		       int rowcount = sh.getLastRowNum();
		      // System.out.println("rowcount "+rowcount);
		       return rowcount;
	
	}
	
	public int columnCount() throws IOException {
		
		InputStream fis = new FileInputStream(url);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		       int columncount = sh.getRow(1).getLastCellNum();
		       //System.out.println("columncount "+columncount);
		       return columncount;
	
	}
	
	public String[][] readData() throws IOException {
		
		InputStream fis = new FileInputStream(url);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  int rowcount = sh.getLastRowNum() +1;
		       int columncount = sh.getRow(1).getLastCellNum();
		      // System.out.println("rowcount "+rowcount);
		      // System.out.println("columncount "+columncount);
		       
		       
		      String data[][]= new String[rowcount][columncount];
		      
		      for(int row=1 ; row < rowcount ; row++) {
		    	  
		    	  
		    	  for (int col = 0 ; col < columncount ; col++) {
		    		  
		    		String d  = sh.getRow(row).getCell(col).getStringCellValue();
		    		
		    		 // System.out.print("Value:" +row +" "+col+" "+d);
		    		  data[row][col] = d;
		    	  }
		    	//  System.out.println();
		      }
		      
		     // System.out.println(data);
		      
		      //Print array
		    /*  for(int row = 1 ; row < rowcount; row++) {
		    	  
		    	  for (int col = 0 ; col < columncount ; col++) {
		    		  
		    		  System.out.print(data[row][col]); 
		    	  }
		    	  System.out.println();
		      }*/
		      
		      return data;
	}
	

}

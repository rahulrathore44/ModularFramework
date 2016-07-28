/**
 * rsr 
 *
 *Jul 28, 2016
 */
package com.modular.framework.helper.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.modular.framework.helper.logger.LoggerHelper;
import com.modular.framework.interfaces.IexcelReader;

/**
 * @author rsr
 *
 * Jul 28, 2016
 */
public class ExcelReaderHelper implements IexcelReader {
	
	private XSSFWorkbook wBook = null;
	private String sheetName = "";
	
	public static final Logger log = LoggerHelper.getLogger(ExcelReaderHelper.class);
	
	public ExcelReaderHelper(String xlFile,String sheetName) {
		this(new File(xlFile),sheetName);
	}
	
	public ExcelReaderHelper(File xlFile,String sheetName) {
		try {
			wBook = new XSSFWorkbook(xlFile);
		} catch (InvalidFormatException | IOException e) {
			log.error("Error in opening Excel Sheet : " + xlFile.getAbsolutePath(),e);
			e.printStackTrace();
		}
		this.sheetName = sheetName;
	}
	
	public void setNewSheet(String sheetName) {
		this.sheetName = sheetName;
	}
	
	private List<String> getHeaderArray() {
		LinkedList<String> header = new LinkedList<String>();
		XSSFSheet sSheet = wBook.getSheet(sheetName);
		
		for(int i = sSheet.getRow(0).getFirstCellNum(); i < sSheet.getRow(0).getLastCellNum(); i++){
			header.add(sSheet.getRow(0).getCell(i).getStringCellValue());
			log.debug(sSheet.getRow(0).getCell(i).getStringCellValue());
		}
		return header;
	}
	
	@Override
	public Object[][] getData() {
		XSSFSheet sheet = wBook.getSheet(sheetName);
		int totalCol = sheet.getRow(0).getLastCellNum();
		List<String> header = getHeaderArray();
		Object[][] data = new Object[sheet.getLastRowNum()][1]; 
		LinkedHashMap<String, Object> xlData = null;
		
		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			xlData = new LinkedHashMap<String,Object>();
			XSSFRow dRow = sheet.getRow(i);
			
			if(null == dRow){
				log.info("Empty row, stopping the excel reader");
				break;
			}
			
			for(int j = dRow.getFirstCellNum(); j < totalCol; j++){
				
				switch (dRow.getCell(j).getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					xlData.put(header.get(j), dRow.getCell(j).getStringCellValue());
					log.debug(header.get(j) + " : " + dRow.getCell(j).getStringCellValue());
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					xlData.put(header.get(j), dRow.getCell(j).getNumericCellValue());
					log.debug(header.get(j) + " : " + dRow.getCell(j).getNumericCellValue());
					break;
				}
			}
			data[i-1][0] = xlData;
		}
		return data;
	}

	@Override
	public Object[][] getData(String sheet) {
		this.sheetName = sheet;
		return getData();
	}

}

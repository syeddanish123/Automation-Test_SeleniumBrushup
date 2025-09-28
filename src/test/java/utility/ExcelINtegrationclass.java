package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelINtegrationclass {

	public FileInputStream fis;
	String path;
	
	ExcelINtegrationclass(String path)
	{
		this.path=path;
	}
	
	public int getColumn() throws Exception {
		
		fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheet("Sheet1");
		int col=st.getRow(0).getLastCellNum();
		return col;
	}
	
    public int getrow() throws Exception {
		
		fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheet("Sheet1");
		int row=st.getLastRowNum();
		return row;
	}
    
    public String getrowcol(int row,int cell) throws Exception {
		
		fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheet("Sheet1");
		XSSFRow rw=st.getRow(row);
		XSSFCell cl=rw.getCell(cell);
		
		DataFormatter formatter=new DataFormatter();
		String cleandata=formatter.formatCellValue(cl);
		
		return cleandata;
	}
}

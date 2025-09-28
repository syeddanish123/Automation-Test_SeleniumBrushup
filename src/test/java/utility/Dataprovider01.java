package utility;

import org.testng.annotations.DataProvider;

public class Dataprovider01 {

	@DataProvider(name="dp1")
	public Object[] dataprovider() {
		
	Object a[]= {"iphone","android","Mac","headphone"};
	
	    return a;
	}
	
	@DataProvider(name="dp2")
	public Object[][] dataproviders() throws Exception {
		
	String path=System.getProperty("user.dir")+"//src//test//resources//inventory_data.xlsx";
	ExcelINtegrationclass dt=new ExcelINtegrationclass(path);
	Object b[][]=new Object[dt.getrow()][dt.getColumn()];
	
	 for(int i=0;i<dt.getrow();i++)
	 {
		 for(int j=0;j<dt.getColumn();j++)
		 {
			 b[i][j]=dt.getrowcol(i, j);
		 }
	 }
	 
	  return b;
	}
	
}

package functionDef;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelOperation {
	@SuppressWarnings("deprecation")
	public static Map<String,String> getDatafromExcel(String dataGenfile,String sheetName) throws Exception
	{
		Map<String,String> testData=new TreeMap<String,String>();
		String query=null;
		query=String.format("SELECT * FROM %s", sheetName);
		Fillo fillo=new Fillo();
		com.codoid.products.fillo.Connection conn=null;
		Recordset recset=null;
		System.out.println(dataGenfile);
		
	try {
		conn=fillo.getConnection(dataGenfile);
		recset = conn.executeQuery(query);
		while(recset.next())
		{
			for (String field:recset.getFieldNames())
			{
				System.out.println(recset.getField("Email ID's")); 
				testData.put(field,recset.getField(field) );
			}
		}
	} catch (FilloException e) {
	    e.printStackTrace();
	    throw new Exception("Could not find Test Data");
	}	
		
		conn.close();
		return testData;
	}
}

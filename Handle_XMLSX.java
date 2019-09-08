import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JLabel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Handle_XMLSX extends Main
{

	public Vector<String> checkStatusFromName(String name, boolean extreme)
	{
		Vector<String> info = new Vector<String>();
		name = name.toUpperCase();
		File excelFile = new File("test.xlsx");
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;
	    try
		{
			fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fis);

		}
	    catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    
	 // we iterate on rows
	    Iterator<Row> rowIt = sheet.iterator();

	    while(rowIt.hasNext()) {
	      Row row = rowIt.next();

	      // iterate on cells for the current row
	      Iterator<Cell> cellIterator = row.cellIterator();

	      while (cellIterator.hasNext()) {
	        Cell cell = cellIterator.next();
	        //aici verific user input pe nume
	        if (cell.toString().equals(name) || cell.toString().contains(name))
	        {
	        	//
	        	//NUMELE
	        	//
	        	info.add(cell.toString());
	        	//System.out.println(cell.toString());
	        	//
	        	//	CAUTARE IN "EXTREME" INSEAMNA CA O SA IA NUMAI NUMELE FARA DETALII DESPRE EL
	        	if(extreme)
	        	{
	        		break;
	        	}
	        	
	        	while (cellIterator.hasNext()) 
	        	{
	    	        Cell cell2 = cellIterator.next();
	//    	        System.out.println(cell2.toString());
	    	        info.add(cell2.toString());
	        	}
		        	
	        }
	        
	      }
	    }

	    try
		{
			workbook.close();
		    fis.close();

		} 
	    catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return info;

	}
	
}

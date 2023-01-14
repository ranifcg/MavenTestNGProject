package testng_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




public class ReadExcelTest {

	public static void main(String[] args) throws IOException{
		
		File file = new File("C:\\Users\\CT181LL\\eclipse-workspace\\MavenTestNGProject\\DataSource.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		//Horrible Spread Sheet Format
		
		//by default Sheet 0 - first sheet
		HSSFSheet sh = wb.getSheetAt(0);
		
		//anything with x..xlsx,docx start with H. HWPF for word,HPSF for ny MS Office
		int rowcount = sh.getLastRowNum() - sh.getFirstRowNum();
		int cellcount = sh.getRow(1).getLastCellNum();
		
		String values[][] = new String[rowcount][cellcount];
		
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<cellcount; j++)
			{
				values[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		for(int k=0;k <values.length; k++)
		{
			for(int l=0; l<cellcount; l++)
				
			{
				System.out.println(values[k][l]);
			}
		}

	}

}

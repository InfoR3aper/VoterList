import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class TestPdf {
	
	String WARD_BELLANDUR = "283 284 285 291 292 293 294 295 330 331 332 333 334 335 336 337 338 339 340 341 342 355 356 357 358 359" +
			"360	361	362	363	364	365	366	367	368	369	370	371	372	373	374	375 376 377 378	379	380	384	385	386	387	388	389	390	391";

public void test() throws IOException{
	
	Workbook workbook = new HSSFWorkbook();
	 
	 Sheet vListSheet = workbook.createSheet("Vlist");
	String j = "";
	int rowIndex = 0;
	 
	for(int i=1;i<386;i++){
		
		if(i < 10 ){
			j = "00"+i;
		}else if (i<100){
			j = "0"+i;
		}else{
			j=""+i;
		}
		
	//	URL url16 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2016/English/WOIMG/AC174/AC1740"+j+".pdf");
	//	URL url17 = new URL("http://ceokarnataka.kar.nic.in/DraftRolls_2017/English/WOIMG/AC174/AC1740"+j+".pdf");
		
		URL url15 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2015/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL url16 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2016/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL urldraft17 = new URL("http://ceokarnataka.kar.nic.in/DraftRolls_2017/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL url17 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll-2017/English/WOIMG/AC151/AC1510"+j+".pdf");
		
		String booth15 = getBoothtotal(url15);
		String booth16 = getBoothtotal(url16);
		String boothDraft17 = getBoothtotal(urldraft17);
		String booth17 = getBoothtotal(url17);
		
		
		 Row row = vListSheet.createRow(rowIndex++);
		 
		 int cellIndex = 0;
		  row.createCell(cellIndex++).setCellValue(i);
		  row.createCell(cellIndex++).setCellValue(booth15);
		  row.createCell(cellIndex++).setCellValue(booth16);
		              row.createCell(cellIndex++).setCellValue(boothDraft17);
		              row.createCell(cellIndex++).setCellValue(booth17);
		              
		              System.out.println("Booth2015 final " +i  +"  "  + booth15);
		            //  System.out.println("Booth2016 final " +i  +"  "  + booth16);
		              /*System.out.println("Booth2017 Draft " +i  +"  "  + boothDraft17);
		              System.out.println("Booth2017 Final " +i  +"  "  + booth17);
*/	}
	
	try {
		            FileOutputStream fos = new FileOutputStream("krpuram.xls");
		            workbook.write(fos);
		            fos.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	
	
	
}

 String getBoothtotal(URL url)throws IOException{
	 HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.connect();
		
		PdfReader pdfr = new PdfReader(con.getInputStream());
		
		String page = PdfTextExtractor.getTextFromPage(pdfr, 1);
		con.disconnect();
		return page.substring(page.lastIndexOf(" ")+1);
 }


public static void main(String args[]) {

	TestPdf tp = new TestPdf();
try{
	tp.test();
} catch(Exception e){
	System.out.println(e.getStackTrace());
}
}

}


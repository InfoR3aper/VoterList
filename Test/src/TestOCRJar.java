


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.asprise.util.pdf.PDFReader;
import com.asprise.ocr.Ocr;


public class TestOCRJar {
	
	String WARD_BELLANDUR = "283 284 285 291 292 293 294 295 330 331 332 333 334 335 336 337 338 339 340 341 342 355 356 357 358 359" +
			"360	361	362	363	364	365	366	367	368	369	370	371	372	373	374	375 376 377 378	379	380	384	385	386	387	388	389	390	391";

public void test() throws IOException{
	
	Workbook workbook = new HSSFWorkbook();
	 
	 Sheet vListSheet = workbook.createSheet("Vlist4");
	String j = "";
	int rowIndex = 0; 
	 
	for(int i=7;i<=8;i++){
		
		if(i < 10 ){
			j = "00"+i;
		}else if (i<100){
			j = "0"+i;
		}else{
			j=""+i;
		}
		
	//	URL url16 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2016/English/WOIMG/AC174/AC1740"+j+".pdf");
	//	URL url17 = new URL("http://ceokarnataka.kar.nic.in/DraftRolls_2017/English/WOIMG/AC174/AC1740"+j+".pdf");
		/*URL url15 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2015/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL url16 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll_2016/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL urldraft17 = new URL("http://ceokarnataka.kar.nic.in/DraftRolls_2017/English/WOIMG/AC151/AC1510"+j+".pdf");
		URL url17 = new URL("http://ceokarnataka.kar.nic.in/FinalRoll-2017/English/WOIMG/AC151/AC1510"+j+".pdf");*/
		
		//URL urldraft18 = new URL("http://ceokarnataka.kar.nic.in/DraftRolls_2018/Kannada/AC151/AC1510"+j+".pdf");
		
		//String fileName = "D://BJP//2016_FinalRolls//KRP//"+"AC1510"+j+".pdf";
		
		String fileName = "D:\\BJP\\2018\\2018_Nov_Mahadevapura\\"+"AC1740"+j+".pdf";
		
		/*String booth15 = getBoothtotal(url15);
		String booth16 = getBoothtotal(url16);*/
		String boothDraft17 = getBoothtotal(fileName, j);
		/*String booth17 = getBoothtotal(url17);*/
		
		
		 Row row = vListSheet.createRow(rowIndex++);
		 
		 int cellIndex = 0;
		  row.createCell(cellIndex++).setCellValue(i);
		  /*row.createCell(cellIndex++).setCellValue(booth15);
		  row.createCell(cellIndex++).setCellValue(booth16);
		              row.createCell(cellIndex++).setCellValue(boothDraft17);
		              row.createCell(cellIndex++).setCellValue(booth17);*/
		  
		   row.createCell(cellIndex++).setCellValue(boothDraft17);
		              
		              System.out.println("Booth2018 draft " +i  +"  "  + boothDraft17);
		              /*System.out.println("Booth2016 final " +i  +"  "  + booth16);
		              System.out.println("Booth2017 Draft " +i  +"  "  + boothDraft17);
		              System.out.println("Booth2017 Final " +i  +"  "  + booth17);*/
	}
	
	try {
		            FileOutputStream fos = new FileOutputStream("KRPuram.xls");
		            workbook.write(fos);
		            fos.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	
	
	
}

 String getBoothtotal(String fileName, String j)throws IOException{
	/* HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.connect();
		*/
		//PdfReader pdfr = new PdfReader(new FileInputStream(new File(fileName)));
	 
	 /*PDFReader pdfr = new PDFReader(new File(fileName));
	 pdfr.open();*/
	 
	 Ocr.setUp(); // one time setup
	 Ocr ocr = new Ocr(); // create a new OCR engine
	 ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
	 
	// BufferedImage img = pdfr.getPageAsImage(1);
	   
	   // recognizes both characters and barcodes
	  // String text = new Ocr().recognizeAll(img);
	   
	 /*  String s =new Ocr().recognize(img,
			   Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);*/
	 
	 String s = ocr.recognize("D:\\BJP\\2018\\2018_Nov_Mahadevapura\\"+"AC1740"+j+".pdf", 0, -1, -1, -1, -1, 
			  Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
	 
	 ocr.stopEngine();
	 
	// pdfr.close();
	 
//String page =	 pdfr.extractTextFromPage(1);
	 /* System.out.println( "Is Encrypted " +  pdfr.isEncrypted());
	*/	
	/* PdfReaderContentParser parser = new PdfReaderContentParser(pdfr);
     String page =  parser.processContent(1, new SimpleTextExtractionStrategy()).getResultantText();*/
	 
		//String page = PdfTextExtractor.getTextFromPage(pdfr, 1);
		//con.disconnect();
	 
		
	 
		//return s.substring(s.lastIndexOf(" ")+1);
	 
	 return s.substring(s.length()-5);
 }


public static void main(String args[]) {

	TestOCRJar tp = new TestOCRJar();
try{
	tp.test();
} catch(Exception e){
	System.out.println(" Exception" +e.getStackTrace());
	System.out.println("Exception"+e.getMessage());
}
}

}


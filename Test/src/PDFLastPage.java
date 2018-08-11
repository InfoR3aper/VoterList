import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.asprise.ocr.util.StringUtils;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFLastPage {
	
	String WARD_BELLANDUR = "283 284 285 291 292 293 294 295 330 331 332 333 334 335 336 337 338 339 340 341 342 355 356 357 358 359" +
			"360	361	362	363	364	365	366	367	368	369	370	371	372	373	374	375 376 377 378	379	380	384	385	386	387	388	389	390	391";

public void test() throws IOException{
	
	Workbook workbook = new HSSFWorkbook();
	 
	 Sheet vListSheet = workbook.createSheet("Vlist4");
	String j = "";
	int rowIndex = 0;
	 
	for(int i=1;i<=412;i++){
		
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
		
		String fileName = "D:\\BJP\\2018\\2018_Final_Mahadevapura\\"+"AC1740"+j+".pdf";
		
		/*String booth15 = getBoothtotal(url15);
		String booth16 = getBoothtotal(url16);*/
		String boothDraft17 = getBoothtotal(fileName, j);
		/*String booth17 = getBoothtotal(url17);*/
		
		
	/*	 Row row = vListSheet.createRow(rowIndex++);
		 
		 int cellIndex = 0;
		  row.createCell(cellIndex++).setCellValue(i);
		  row.createCell(cellIndex++).setCellValue(booth15);
		  row.createCell(cellIndex++).setCellValue(booth16);
		              row.createCell(cellIndex++).setCellValue(boothDraft17);
		              row.createCell(cellIndex++).setCellValue(booth17);
		  
		   row.createCell(cellIndex++).setCellValue(boothDraft17);
		              
		              System.out.println("Booth2018 draft " +i  +"  "  + boothDraft17);
		              System.out.println("Booth2016 final " +i  +"  "  + booth16);
		              System.out.println("Booth2017 Draft " +i  +"  "  + boothDraft17);
		              System.out.println("Booth2017 Final " +i  +"  "  + booth17);*/
	}
	
/*	try {
		            FileOutputStream fos = new FileOutputStream("2018_Final_Mahadevapura.xls");
		            workbook.write(fos);
		            fos.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }*/

	
	
	
}

 String getBoothtotal(String fileName,String boothnum)throws IOException{
	/* HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.connect();
		*/
		//PdfReader pdfr = new PdfReader(new FileInputStream(new File(fileName)));
	 
	 PdfReader pdfr = new PdfReader(fileName);

	 /* System.out.println( "Is Encrypted " +  pdfr.isEncrypted());
	*/	
	/* PdfReaderContentParser parser = new PdfReaderContentParser(pdfr);
     String page =  parser.processContent(1, new SimpleTextExtractionStrategy()).getResultantText();*/
	 
		String page = PdfTextExtractor.getTextFromPage(pdfr, pdfr.getNumberOfPages());
		//con.disconnect();
	 
		
	 
		/*String additionList =  page.substring(page.lastIndexOf("Additions List Supplement -  1 Special Summary ")+1);
		
		String finalString = getBetweenStrings(page, "Additions List", "Revision-2018");
		
		String  additions = null;
		if(finalString!=null)
		  additions = finalString.substring(finalString.lastIndexOf(" ")+1);
		
		String deletionString = getBetweenStrings(page, "Deletions List", "Revision-2018");
		
		String  deletions = null;
		if(deletionString!=null)
			deletions = deletionString.substring(deletionString.lastIndexOf(" ")+1);
		
		System.out.println(" Additions List:  "+ additions.replace("\n", "")  + "  Deletions List:  "+deletions.replace("\n", ""));*/
		
		String modifications = null;
		
		String modString = getBetweenStrings(page, "NUMBER OF CORRECTIONS", "Revision-2018");
		modifications = modString.substring(modString.lastIndexOf(" ")+1);
		
		System.out.println(modifications.replace("\n", ""));
		
		return null;
		
		
 }
 
 public static String getBetweenStrings(
		    String text,
		    String textFrom,
		    String textTo) {

		    String result = "";

		    // Cut the beginning of the text to not occasionally meet a      
		    // 'textTo' value in it:
		    result =
		      text.substring(
		        text.indexOf(textFrom) + textFrom.length(),
		        text.length());

		    // Cut the excessive ending of the text:
		    result =
		      result.substring(
		        0,
		        result.indexOf(textTo));

		    return result;
		  }


public static void main(String args[]) {

	PDFLastPage tp = new PDFLastPage();
try{
	tp.test();
} catch(Exception e){
	System.out.println(" Exception" +e.getStackTrace());
	System.out.println("Exception"+e.getMessage());
}
}

}


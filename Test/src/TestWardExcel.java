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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWardExcel {
	
	String Bellandur[] = new String[]{"283","284","285","291","292","293","294","295","330","331","332","333","334","335","336","337","338","339","340","341","342","355","356","357","358","359",
			"360","361","362","363","364","365","366","367","368","369","370","371","372","373","374","375","376","377","378","379","380","384","385","386","387","388","389",
			"390"};
	
	String DoddaNekundi[] = new String[]{
			"206","207","208","209","210","211","212","213","218","219","220","221","222","254","255","214","215","216","217","250","251","252","253","223",
			"224","225","226","227","228","229","230","231","232","233","234","235","267","268","269","270","306","307","308","309","310","311"};
	
	String GarudacharPalya[] = new String[]{
			"139","140","141","142",
			"146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167",
			"195","196","197","228","229"
	};
	
	String Hagdur[] = new String[]{
			"168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188",
			"230","231","232","233","234","235","236","237","238","239","240","241","301","302","303","304","305","306","307","308"
	};
	
	String Hudi[] = new String[]{
			"34","35","36","37","38","39","40","41","42","84","85","91","92","93","94","95","96","97","98",
			"125","126","127","128","129","130","131","132","133","134","135","136","137","138","143","144","145"
	};

	String Kadugodi[] = new String[]{
			"99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124",
			"189","190","191","192","193","194"	
	};
	
	String Kodathi[] = new String[]{
			"354","381","382","383","391","392","393","394","395","396","397","398","399"
	};
	
	String Marathalli[] = new String[]{
			"248","249","250","251","252","253","254","255","256","257","258","263","264","265","266","267","268","269","270","271",
			"286","287","288","289","290"	
	};
	
	String Varthur[] = new String[]{
			"272","273","274","275","276","277","278","279","280","281","282","309","310","311","312","313","314","315","316","317",
			"318","319","320","321","322","323","324","325","326","327","328","329","343","344","345","346","347","348","349","350","351","352","353"
	};
	
	String Bidrahalli[] = new String[]{
			"8","9","22","28","29","30","43","44","50","51","52"
	};
	
	String Mandur[] = new String[]{
			"2","3","4","5","6","7","23","24","25","26","27"
	};
	
	String Kannamangala[] = new String[]{
			"56","57","58","59","60","61","62","63","64","74","75","76","77","78","79","80","81","82","83",
			"87","88","89","90"
	};
	
	String KANNUR[] = new String[]{
			"1","10","11","12","13","14","15","16","17","18","19","20","21","31","32","33"

	};
	
	String AVALAHALLI[] = new String[]{
			"45","46","47","48","49","53","54","55","65","66","67","68","69","70","71","72","73","86"
	};
	
public void test() throws IOException{
	
	/*Workbook workbook = new HSSFWorkbook();
	 
	 Sheet vListSheet = workbook.createSheet("Vlist");*/
	/*String j = "";
	int rowIndex = 0;*/
	
	
		
		String j = "";
		int rowIndex = 0;
		
		String WardName = "DoddaNekundi";
		
		Workbook workbook = new HSSFWorkbook();
		 
		 Sheet vListSheet = workbook.createSheet("DoddaNekundi2018");
	
	List Ward_List = Arrays.asList(DoddaNekundi);
	
	for(int i=1;i<=Ward_List.size();i++){
		
		if(Ward_List.contains(String.valueOf(i))) {
		
		if(i < 10 ){
			j = "00"+i;
		}else if (i<100){
			j = "0"+i;
		}else{
			j=""+i;
		}
		
		
		 Row row = vListSheet.createRow(rowIndex++);
		 
		 int cellIndex = 0;
		  row.createCell(cellIndex++).setCellValue(i);
		  row.createCell(cellIndex++).setCellValue(booth15);
		  row.createCell(cellIndex++).setCellValue(booth16);
		              row.createCell(cellIndex++).setCellValue(boothDraft17);
		              row.createCell(cellIndex++).setCellValue(booth17);
		              
		              System.out.println("Booth2015 final " +i  +"  "  + booth15);
		
		
		
		}
	}
	 System.out.println("Ward Name : "  + WardName);
	try {String filename = WardName+".xls";
		            FileOutputStream fos = new FileOutputStream(filename);
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

	TestWard tp = new TestWard();
try{
	tp.test();
} catch(Exception e){
	System.out.println(e.getStackTrace());
}
}

}




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
	 
	public class TestDownloadKRPuram {
		 private static final int BUFFER_SIZE = 4096;
		
		public static void downloadFile(String fileURL, String saveDir)
	            throws IOException {
			
	        URL url = new URL(fileURL);
	        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConn.getResponseCode();
	 
	        // always check HTTP response code first
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            String fileName = "";
	            String disposition = httpConn.getHeaderField("Content-Disposition");
	           /* String contentType = httpConn.getContentType();
	            int contentLength = httpConn.getContentLength();*/
	 
	            if (disposition != null) {
	                // extracts file name from header field
	                int index = disposition.indexOf("filename=");
	                if (index > 0) {
	                    fileName = disposition.substring(index + 10,
	                            disposition.length() - 1);
	                }
	            } else {
	                // extracts file name from URL
	                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
	                        fileURL.length());
	            }
	 
	          /*  System.out.println("Content-Type = " + contentType);
	            System.out.println("Content-Disposition = " + disposition);
	            System.out.println("Content-Length = " + contentLength);*/
	            System.out.println("fileName = " + fileName);
	 
	            // opens input stream from the HTTP connection
	            InputStream inputStream = httpConn.getInputStream();
	            String saveFilePath = saveDir + File.separator + fileName;
	             
	            // opens an output stream to save into file
	            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
	 
	            int bytesRead = -1;
	            byte[] buffer = new byte[BUFFER_SIZE];
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	 
	            outputStream.close();
	            inputStream.close();
	 
	            System.out.println("File downloaded");
	        } else {
	            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
	        }
	        httpConn.disconnect();
	    }
	 
	    public static void main(String[] args) {
	    	
	        try {
	        	String j = "";
		    	//String saveDir = "D:/BJP/2017_Final_10012017";
	        	String saveDir = "D:/BJP/2018/2018_Nov_Mahadevapura";
		    	String fileURL=null;
		    	for(int i=1;i<=412;i++){
		    		if(i < 10 ){
		    			j = "00"+i;
		    		}else if (i<100){
		    			j = "0"+i;
		    		}else{
		    			j=""+i;
		    		}
		    		//fileURL =  "http://ceokarnataka.kar.nic.in/FinalRoll-2017/English/WOIMG/AC174/AC1740"+j+".pdf";
		    		fileURL =  "http://ceokarnataka.kar.nic.in/DraftRolls_2018/English/AC174/AC1740"+j+".pdf";
		    		 downloadFile(fileURL, saveDir);
		    	}
	           
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	

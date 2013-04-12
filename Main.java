import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;

/* ga */
/* sources : http://docs.oracle.com/javase/tutorial/essential/io/charstreams.html */
/* sources : http://docs.oracle.com/javase/tutorial/essential/environment/properties.html */
public class Main {

	public static void main(String[] args) {
		
		if (args.length != 2) {

			System.out.println("Please enter two input file names");
		}
		else {
			
			File fquery = new File(args[0]);
			File fconfig = new File(args[1]);
			
			/* 		AL queryLines holds one line from query.txt per AL's element 	*/
			ArrayList<String> queryLines = new ArrayList<String>();  
			
	        	BufferedReader inputStream = null;
	        	PrintWriter outputStream = null;
	        
	        /* 		reading query.txt into AL		*/
	        try {
	        	
	            inputStream = new BufferedReader(new FileReader(fquery));

	            String l;
	            while ((l = inputStream.readLine()) != null) {
	            	
	            	queryLines.add(l);
	            }
	        } 
	        catch (IOException e) {

				e.printStackTrace();
		} 
	        finally {
				
	            if (inputStream != null) {
	        
	        	try {
	                	
				inputStream.close();
			} 
	                catch (IOException e) {
						
				e.printStackTrace();
			}
	            }
	        }
	        /* 		reading config.properties file 		*/
	        Properties costProps = new Properties();
	        FileInputStream in = null;
	        
			try {
				
				in = new FileInputStream(fconfig);
			} 
			catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
	        try {
	        	
			costProps.load(in);
		}
	        catch (IOException e) {
				
			e.printStackTrace();
		}
	        try {
	        	
				in.close();
		} 
	        catch (IOException e) {
				
				e.printStackTrace();
		}
	        /* 		writing dummy output.txt 	*/
	        try {
	        	
			outputStream = new PrintWriter(new FileWriter("output.txt"));

		        for (String line : queryLines) {

	            	outputStream.println("==================================================================");
	                outputStream.println(line);
	                outputStream.println("------------------------------------------------------------------");
	                outputStream.println();
	                outputStream.println("OPTIMAL PLAN HERE"); 
	                outputStream.println();
	                outputStream.println("------------------------------------------------------------------");
	                outputStream.println("cost: XX.X");
		        }
		} 
	        catch (IOException e) {
				
				e.printStackTrace();
		}
	        finally {
	        	
	            if (outputStream != null) {
	            	
	                outputStream.close();
	            }
	        }
	        /* 		AL elements test     */
	        System.out.println("AL test");
	        for (String line : queryLines) {
	        	
	        	System.out.println(line);
	        }
	        /* 		Properties test     */
	        /*	 	NOTE : properties values of type String!     */
	        System.out.println("Properties test");
	        System.out.println("* NOTE : properties values are of type String!");
	        System.out.println("# : " + costProps.size());
	        System.out.println("r = " + costProps.getProperty("r"));
	        System.out.println("t = " + costProps.getProperty("t"));
	        System.out.println("l = " + costProps.getProperty("l"));
	        System.out.println("m = " + costProps.getProperty("m"));
	        System.out.println("a = " + costProps.getProperty("a"));
	        System.out.println("f = " + costProps.getProperty("f"));
	        }
	}	
}
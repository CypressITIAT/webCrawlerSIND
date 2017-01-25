package WebCrawler;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Main{
	
	 
	  
	 public static ArrayList<String> searchCriteria=new ArrayList<String>();
	 public static String keyToTest;
	
	public static void main(String[] args) throws IOException {
		
		String url = "http://www.mit.edu/";
		keyToTest="research";
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
		System.setProperty("http.proxyHost", "proxy.india.cypress.com");
		System.setProperty("http.proxyPort", "8080");
		
		    processAction(url,searchCriteria,keyToTest);
    
    
    
   
	}

	public static void processAction(String url, ArrayList<String> searchCriteria2, String keyToTest2) throws IOException {
		// TODO Auto-generated method stubSystem.setProperty("http.proxyHost", "proxy.india.cypress.com");
		System.setProperty("http.proxyHost", "proxy.india.cypress.com");
		System.setProperty("http.proxyPort", "8080");
	    Document doc = Jsoup.connect(url).get();
	    String title = doc.title();  
	    System.out.println("title is: " + title);  
	    
	   int rank = 0;
	  

	   System.out.println(keyToTest2);
	   

	    Elements links = doc.select("a[href]");
	    for (Element link : links) {
	    	if(link.text().contains(keyToTest2)){
	    	
	    		searchCriteria.add(link.attr("abs:href"));
	    		
	     System.out.println(link.attr("abs:href"));
	    	}
	    }

	    
	    
	 
	    
	 System.out.println("rank is "+searchCriteria.size());
	 System.out.println("Pages containing the specific keyword");
	 
	 searchCriteria.forEach(System.out::println);
		
	}
}




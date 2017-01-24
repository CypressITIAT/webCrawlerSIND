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
	
	public static void main(String[] args) throws IOException {
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
    String url = "http://www.mit.edu/";
	System.setProperty("http.proxyHost", "proxy.india.cypress.com");
	System.setProperty("http.proxyPort", "8080");
    Document doc = Jsoup.connect("http://www.mit.edu/").get();
    String title = doc.title();  
    System.out.println("title is: " + title);  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   int rank = 0;
   System.out.println("Enter  Search "
   		+ "Keyword");
   String key="molecule";
if(key !=null &&!( key.equals(""))){
   System.out.println(key);
    Map<String,ArrayList<String> >mapObject =new HashMap<String,ArrayList<String>>();
  
    ArrayList<String> searchCriteria=new ArrayList<String>();

    Elements links = doc.select("a[href]");
    for (Element link : links) {
    	if(link.text().contains(key)){
    		
    		searchCriteria.add(link.attr("abs:href"));
     System.out.println(link.attr("abs:href"));
    	}
    	
    	
    }
    mapObject.put(key,searchCriteria);
    key=key.toUpperCase();

    switch(key){
    case "RESEARCH":
    	rank=1;
    	break;
    case "TECHNOLOGY":
       rank=2;
       break;
    case "FACILITIES":
        rank=3;
        break;
    }
 
    
 System.out.println("rank is "+rank);
 System.out.println("Pages containing the specific keyword");
 
 searchCriteria.forEach(System.out::println);
    	
    
    
    }
   
	}
}
	




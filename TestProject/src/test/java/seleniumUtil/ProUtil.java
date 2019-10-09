package seleniumUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ProUtil {
	private  Properties prop = new Properties();
	public ProUtil(String file) {
		  try {
			  prop= new Properties();
	          //  Properties.class.getClassLoader().getResourceAsStream("config/config.properties");
			  prop.load(new FileInputStream("elements.properties")) ;
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	}
	public String getPro(String key) {
		String content=prop.getProperty(key);
		return content;
	}
	
}

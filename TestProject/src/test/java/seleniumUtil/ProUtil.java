package seleniumUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ProUtil {
	private  Properties prop = new Properties();
	public ProUtil(String file) {
		  try {
	            InputStream in = Properties.class.getResourceAsStream(file);
	            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
	            prop.load(bf);
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	}
	public String getPro(String key) {
		String content=prop.getProperty(key);
		return content;
	}
	
}

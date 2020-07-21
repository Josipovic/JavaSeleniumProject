package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public Properties prop;
	
       public BaseClass() {
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("E:\\Java repos novi\\SauceDemo1\\src\\main\\java\\config\\properties");
		   prop.load(ip);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

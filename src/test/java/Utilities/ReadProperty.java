package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	String filepath=".//TestData//config.properties";
	Properties pr;
	
	public ReadProperty()
	{
		try {
		FileInputStream fis=new FileInputStream(filepath);
		pr=new Properties();
		pr.load(fis);
	}
		catch(Exception e)
		{
			System.out.println("File not found!!!!");
		}
	}
	public String getApllicationurl()
	{
		String url=pr.getProperty("baseurl");
		return url;
	}
	
	public String getUsername()
	{
		String user=pr.getProperty("username");
		return user;
	}
	
	public String getPassword()
	{
		String user=pr.getProperty("password");
		return user;
	}
}

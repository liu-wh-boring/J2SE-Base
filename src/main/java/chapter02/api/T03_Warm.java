package chapter02.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class T03_Warm 
{
	@Test
	public void doGet() 
	{
	    try {
	        String urlStr = "https://bbs.csdn.net";
	        URL url = new URL(urlStr);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestMethod("GET");
	        connection.setUseCaches(false);
	        connection.setInstanceFollowRedirects(false);
	        connection.connect();

	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String ss ,total="";

	        while ((ss = reader.readLine()) != null) {
	            total += ss;
	            total+="\n";
	        }
	        System.out.println("total=" + total);
	        reader.close();
	        connection.disconnect();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

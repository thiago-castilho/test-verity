package br.com.verity.core;

import java.io.FileInputStream;
import java.io.InputStream;

public class Properties {

	public static final boolean CLOSE_BROWSER = false;
	
	
	public static String browsers = getProperty("browser");
	public static String site = getProperty("site");


	private static String getProperty(String property) {
		String value = "";
		System.getProperty("user.dir");
		try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\project.properties")) {
			java.util.Properties properties = new java.util.Properties();
			properties.load(input);
			value = properties.getProperty(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
}

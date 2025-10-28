package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	private static Properties prop;

	public static void loadconfig() throws IOException {
		if (prop == null) {
			prop = new Properties();
			FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
			prop.load(file);
		}
	}

	public static String getProperty(String key) {
		if (prop == null) {
			try {
				loadconfig();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}
}

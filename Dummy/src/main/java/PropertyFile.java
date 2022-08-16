

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
public String getpropertykeyvalue(String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./TestData/Common.properties");
	Properties pboj = new Properties();
	pboj.load(fis);
	String value = pboj.getProperty(key);
	return value;
}
}

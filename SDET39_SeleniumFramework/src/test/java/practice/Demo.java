package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
@Test(retryAnalyzer = com.cast.vtiger.genericUtility.ReTryImpClass.class)
public void modifyContact() {
	Assert.assertEquals(false, true);
	System.out.println("Contact is Modified");
}
}

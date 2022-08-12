package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@Test(dataProvider="dataProvider_test")
public void bookTicket(String src,String dest) {
	System.out.println("Book Ticket From "+src+"To"+dest+"");
}
@DataProvider
public Object[][] dataProvider_test(){
	Object[][] ObjArr = new Object[5][2];
	ObjArr[0][0] ="Bangalore";
	ObjArr[0][1] ="Goa";

	ObjArr[1][0] ="Bangalore";
	ObjArr[1][1] ="mangalore";
	
	ObjArr[2][0] ="Bangalore";
	ObjArr[2][2] ="mysore";
	
	ObjArr[3][0] ="Bangalore";
	ObjArr[3][1] ="Mumbai";
	
	ObjArr[4][0] ="Bangalore";
	ObjArr[4][1] ="Pune";

     return ObjArr;
	
}	
}


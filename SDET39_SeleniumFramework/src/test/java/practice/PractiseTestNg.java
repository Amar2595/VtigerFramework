package practice;

import org.testng.annotations.Test;

public class PractiseTestNg {
@Test
public void CreateContact() {
	System.out.println("The Contact is Created");
}
//Run Three times
@Test(invocationCount= 3) 
public void ModifyContact() {
	System.out.println("The Contact is Modified");
}
@Test(priority=0)
public void DeleteContact() {
	System.out.println("The Contact is Deleted");
}
}

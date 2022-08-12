package com.cast.vtiger.genericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
@BeforeSuite
public void BS() {
	System.out.println("Database Connectivity");
}
@BeforeTest
public void BT() {
	System.out.println("Execute Script in Parellel Mode");
}
@BeforeClass
public void BC() {
	System.out.println("Launching Browser");
}
@BeforeMethod
public void BM() {
	System.out.println("Login to App");
}
@AfterMethod
public void AM() {
	System.out.println("Logout from App");
}
@AfterClass
public void AC() {
	System.out.println("Closing The Browser");
}
@AfterTest
public void AT() {
	System.out.println("Parellel Execution Is Done");
}
@AfterSuite
public void AS() {
	System.out.println("Dissconect DataBase Connectivity");
}

}

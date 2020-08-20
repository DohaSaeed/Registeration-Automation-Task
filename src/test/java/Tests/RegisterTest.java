package Tests;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Data.ExcelReader;
import Pages.RegisterationPage;


/**
 * This class is the RegisterTest class extends from  BaseTest class it contain the  test scenerio and data provider 
 */
public class RegisterTest extends BaseTest {
	RegisterationPage reg;
	
	
	
	/**
	 *  userRegisterData method contain Data provider that get data from Excel Reader class
	 *  @return    Data in excel sheet in 2D array 
	 * 
	 */
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();

		return ER.getExcelData();
	}
	
	/**
	 * method  (RegTest) is the method that create account user
	 *  contain an  argument URL  , Data that will filled in account page
	 * @param  URL the url that will navigate to 
	 * @param  Data that will filled in account page
	 */

	@Test(dataProvider="ExcelData")
	public void RegTest( String FirstName , String LastName ,String mobileNumber , String firstpartofemail, String Lstpartofemail ,  String password , String confirmpassword)
	{
		test = extent.startTest("Log Steps Statuts");
		test.log(LogStatus.PASS,"Browser is Opened now Successfully");
		
		RegisterationPage reg = new RegisterationPage(browserobject);
		
		reg.Fillfieldname(FirstName, LastName);	
		test.log(LogStatus.PASS,"First and last name fields filled successfully");
							
		reg.Fillfieldmobile(mobileNumber);
		test.log(LogStatus.PASS,"mob field filled successfully");
		
		reg.fillfieldemil(firstpartofemail , Lstpartofemail);
		test.log(LogStatus.PASS,"Email field filled successfully");
		
		reg.fillfieldpassword(password , confirmpassword);
		test.log(LogStatus.PASS,"password field filled successfully");
		
		reg.pressbuttonregister();
		test.log(LogStatus.PASS,"user registerd  successfully");
		

		
	}

}

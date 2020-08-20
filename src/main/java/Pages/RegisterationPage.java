package Pages;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



/**
 * This class is the RegisterationPage class that contain constructor to initiate driver and  contain register and create account methods 
 */
public class RegisterationPage extends BasePage {


	public RegisterationPage(WebDriver browserobject) {
		super(browserobject);
		jse = (JavascriptExecutor) browserobject; 
	}



	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
			"[a-zA-Z0-9_+&*-]+)*@" + 
			"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
			"A-Z]{2,7}$";
	String email;
	String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	String Coorectemail= "Email is invalid";
	String CapitalFirstName = "First Name  must start with capital letter";
	String CapitalLastName = "Last Name  must start with capital letter";
	String AseertionFirstandLastName = "Last Name cannot be equal First Name ";
	String coorectPhonenumber="Phone numbers should be eleven-digits long ";
	String passrd ="this is invalid password";
	char currentCharacter;
	Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	Matcher matcher;
	////////////////////////////////////////////////

	By firstName=By.name("firstname");
	By lastname=By.name("lastname");
	By mobile=By.name("phone");
	By eemail =By.name("email");
	By pass =By.name("password");
	By confirpass =By.name("confirmpassword");
	By pressButt=By.cssSelector("button.signupbtn.btn_full.btn.btn-success.btn-block.btn-lg");

	/**
	 * method (Fillfieldname) fill field first name and lastname 
	 */
	public void Fillfieldname(String FirstName , String LastName )
	{
		for (int i = 0; i <1; i++)
		{
			currentCharacter = FirstName.charAt(i);
			if (Character.isUpperCase(currentCharacter))
			{
				browserobject.findElement(firstName).sendKeys(FirstName);

			}
			else
			{
				browserobject.findElement(firstName).sendKeys(CapitalFirstName);
				Assert.fail("First Letter must be Capital");

			}

		}


		for (int i = 0; i <1; i++)
		{
			currentCharacter = LastName.charAt(i);
			if (Character.isUpperCase(currentCharacter) && FirstName != LastName )
			{

				browserobject.findElement(lastname).sendKeys(LastName);

			}
			else if(Character.isLowerCase(currentCharacter)  )
			{
				browserobject.findElement(lastname).sendKeys(CapitalLastName);
				Assert.fail("First Letter must be Capital");

			}


			else
			{
				browserobject.findElement(lastname).sendKeys(AseertionFirstandLastName);
				Assert.assertNotEquals(FirstName, LastName, "First Name cannot  be equal Last Name");
			}

		}
	}

	/**
	 * method (Fillfieldmobile) fill field mobile number
	 */
	public void Fillfieldmobile(String mobileNumber )
	{
		if (mobileNumber.length() <= 11)
		{
			browserobject.findElement(mobile).sendKeys(mobileNumber);
		}
		else
		{
			browserobject.findElement(mobile).sendKeys(coorectPhonenumber);
			Assert.fail("Phone numbers should be eleven-digits long ");
		}
	}

	/**
	 * method (fillfieldemil) fill field email
	 */
	public void fillfieldemil(String firstpartofemail, String Lstpartofemail )
	{
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		email=firstpartofemail+saltStr+Lstpartofemail;

		if(email.matches(emailRegex))
		{
			browserobject.findElement(eemail).sendKeys(email); 

		}
		else
		{
			browserobject.findElement(eemail).sendKeys(Coorectemail);
			Assert.fail("Email is invalid ");
		}

	}
	/**
	 * method (fillfieldpassword) fill field passsword
	 */

	public void fillfieldpassword(String password , String confirmpassword)
	{


		if (!UpperCasePatten.matcher(password).find() ) {
			Assert.fail("pass must contain capital letter ");

		}

		if (! lowerCasePatten.matcher(password).find()) {
			Assert.fail("pass must contain small letter  ");
		}
		if (password.length() >8 ) {

			Assert.fail("pass should be less than 8-digit ");
		}
		if (confirmpassword != password)
		{
			Assert.fail("confirmpassword must  be equal  to password ");
		}

		else 
		{

			browserobject.findElement(pass).sendKeys(password);
			browserobject.findElement(confirpass).sendKeys(confirmpassword);
		}

	}


	/**
	 * method (pressbuttonregister) press on button register 
	 */
	public void pressbuttonregister()
	{
		scrollToBottom();
		WebDriverWait wait4=new WebDriverWait(browserobject, 12);
		wait4.until(ExpectedConditions.elementToBeClickable(pressButt));
		browserobject.findElement(pressButt).click();


	}

}

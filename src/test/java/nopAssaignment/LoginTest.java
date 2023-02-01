package nopAssaignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class LoginTest {
	WebDriver driver ;
	

	@BeforeTest
	public void VerifyLogin() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
	}
	
	@Test
	public void AddCustomer() throws Exception  {
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).clear();
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[@type]")).click();
		Thread.sleep(2000);
		System.out.println("Customer Login Successfully");
		driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//a[@href=\"/Admin/Customer/Create\"]")).click();
		driver.findElement(By.cssSelector("#Email")).sendKeys("Manjusha123@gmail.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Manjusha");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Guntupalli");
		driver.findElement(By.cssSelector("#Gender_Female")).click();
		driver.findElement(By.xpath("//input[@name=\"DateOfBirth\"]")).sendKeys("4/5/1998");
		driver.findElement(By.xpath("//button[@name=\"save\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"))
				.getText().contains("added successfully"));
		System.out.println("Customer added Successfully");
	}
	
	@AfterTest
	public void CloseAPP() {
		driver.close();
	}
}

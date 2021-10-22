package Edit.EducacionITJueves;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionITJueves\\Drivers\\chromedriver.exe";

	@Test
	public void registrarUsuario() {
		// Inicializar el navegador a utilizar en la página AutomationPractice
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.navigate().to(url); // driver.get(url);
		driver.manage().window().maximize();
		
		// Ingresar el correo y hacer clic en el boton Create An Account
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo" + Math.random() + "@micorreo.com");
		
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Llenar el formulario y hacer clic en el botón Register
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Rodrigo");
		
		driver.findElement(By.id("customer_lastname")).sendKeys("Jimenez");
		
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t");
		
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByIndex(5);
		
		Select years = new Select(driver.findElement(By.xpath("//*[@id='years']")));
		years.selectByValue("1985");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.cssSelector("#address1")).sendKeys("Micalle 2345 6B");
		
		driver.findElement(By.id("city")).sendKeys("Cordoba");
		
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Arizona");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("54345");
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		driver.findElement(By.name("phone_mobile")).sendKeys("4657463736");
		
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Dirección de Trabajo");
		
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
}
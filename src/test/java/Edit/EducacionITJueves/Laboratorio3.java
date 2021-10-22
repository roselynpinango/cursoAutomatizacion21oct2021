package Edit.EducacionITJueves;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	WebDriver driver;
	File screen;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITJueves\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test(description="Busqueda de Palabra",priority=4)
	public void buscarPalabra() throws Exception {
		Assert.assertEquals(driver.getTitle(), "Login - My Store");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITJueves\\Evidencias\\pantalla_principal.png"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
				
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITJueves\\Evidencias\\resultado_busqueda.png"));
		
		Assert.assertEquals(driver.getTitle(), "Search - My Store");
	}
	
	@Test(description="Ir a Contáctanos",priority=2)
	public void irAContactUs() {
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
	}
	
	@Test
	public void registroUsuario() {
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
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}

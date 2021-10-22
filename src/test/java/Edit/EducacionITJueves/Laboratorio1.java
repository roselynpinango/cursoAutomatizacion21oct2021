package Edit.EducacionITJueves;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	@Test
	public void hacerBusquedaEnChrome() {
		// Paso 1: Indicar dónde está nuestro driver.exe
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITJueves\\Drivers\\chromedriver.exe");
		
		// Paso 2: Instanciar qué navegador usaremos (WebDriver = Navegador)
		WebDriver navegador = new ChromeDriver();
		
		// Paso 3: Abrir el navegador en la página http://automationpractice.com
		navegador.get("http://automationpractice.com");
		
		// Paso 4: Escribir en el campo de búsqueda (WebElement = elemento de la página)
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		// Paso 5: Hacer la búsqueda simulando que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		// Paso 1: Indicar dónde está nuestro driver.exe
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITJueves\\Drivers\\geckodriver.exe");
		
		// Paso 2: Instanciar qué navegador usaremos (WebDriver = Navegador)
		WebDriver navegador = new FirefoxDriver();
		
		// Paso 3: Abrir el navegador en la página http://automationpractice.com
		navegador.get("http://automationpractice.com");
		
		// Paso 4: Escribir en el campo de búsqueda (WebElement = elemento de la página)
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		// Paso 5: Hacer la búsqueda simulando que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
	}
}

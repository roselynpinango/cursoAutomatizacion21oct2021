package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Test_Laboratorio3_E2 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionITJueves\\Drivers\\chromedriver.exe";
	File screen;
	String nombreDocumento = "..\\EducacionITJueves\\Evidencias\\automationPractice.docx";
	
	@BeforeSuite
	public void setUp() throws Exception, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		CapturaEvidencia.escribirEnDocumento(nombreDocumento, "Documento de Evidencias", 18);
	}
	
	@Test
	public void login() throws IOException, InvalidFormatException, InterruptedException {
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Pantalla Principal");
		
		// Clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();

		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Pantalla de Login");
		
		// Completar correo, contraseña y hacer clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		login.fillEmail("correo001@gmail.com");
		login.fillPassword("1q2w3e4r5t");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Credenciales Utilizadas");
		
		login.clicOnLogin();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Resultado Obtenido");
	}
	
	@Test
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}

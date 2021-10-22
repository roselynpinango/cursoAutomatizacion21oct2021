package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Test_Laboratorio4 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionITJueves\\Drivers\\chromedriver.exe";
	File screen;
	String nombreDocumento; 
	
	@BeforeSuite
	public void setUp() throws Exception, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		/* -- INCONGNITO 
		DesiredCapabilities capabitilies = DesiredCapabilities.chrome();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("incognito");
		capabitilies.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(capabitilies);
		*/
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) throws IOException, InvalidFormatException, InterruptedException {
		nombreDocumento = "..\\EducacionITJueves\\Evidencias\\automationPractice - " + email + ".docx";
		CapturaEvidencia.escribirEnDocumento(nombreDocumento, "Documento de Evidencias", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Pantalla Principal");
		
		// Clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();

		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Pantalla de Login");
		
		// Completar correo, contraseña y hacer clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		login.fillEmail(email);
		login.fillPassword(password);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Credenciales Utilizadas");
		
		login.clicOnLogin();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "..\\EducacionITJueves\\Evidencias\\img.png", nombreDocumento, "Resultado Obtenido");
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionITJueves\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo999@gmail.com";
		datos[0][1] = "56turete";
		
		datos[1][0] = "correo998@gmail.com";
		datos[1][1] = "sear3weraaew";
		
		datos[2][0] = "correo997@gmail.com";
		datos[2][1] = "09olyu8u,";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}

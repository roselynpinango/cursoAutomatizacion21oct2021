package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
	WebElement lnkContactUs;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}

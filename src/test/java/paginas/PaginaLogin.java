package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement btnLogin;
	
	WebDriver driver;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void fillPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clicOnLogin() {
		btnLogin.click();
	}
}

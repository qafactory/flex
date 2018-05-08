import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    @FindBy(xpath = "//div[@class='panel-heading']")
    WebElement header;

    @FindBy(xpath = "//div[@class='login-box']//form")
    WebElement loginForm;

    @FindBy(xpath = "//input[@id='LoginName']")
    WebElement loginField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    WebElement errorValidationMsg;




    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String login, String password) {
        webDriver.get("http://85.214.23.6/testtask9/");
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public boolean isLogingPage() {
        return loginForm.isDisplayed();
    }

    public String getHeader() {
        return header.getText();
    }

    public String getErrorValidationMsg() {
        return errorValidationMsg.getText();
    }
}

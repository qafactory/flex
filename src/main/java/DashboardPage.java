import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Page {

    @FindBy(xpath = "//div[@class='hidden-xs']/a[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class='hidden-xs']/strong")
    WebElement userName;



    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean userIsLogedIn() {
        return logoutLink.isDisplayed();
    }

    public String getUserName() {
        String fullName = userName.getText();
        String name = fullName.substring(0, fullName.length() - 2);
        return name;
    }

    public void logout() {
        logoutLink.click();
    }
}

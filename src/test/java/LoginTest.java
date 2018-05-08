import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setup(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        dashboardPage = PageFactory.initElements(driver,DashboardPage.class);
    }

    @DataProvider(name = "Credentials")
    public static Object[][] credentials() {
        return new Object[][] {
                { "user1", "Uhgf78edKms"}};
    }

    @Test(dataProvider = "Credentials")
    public void userCanLogin(String login, String password){
        loginPage.login(login,password);
        Assert.assertTrue(dashboardPage.userIsLogedIn());
        Assert.assertEquals(dashboardPage.getUserName(),login);

        dashboardPage.logout();
        Assert.assertTrue(loginPage.isLogingPage());
        Assert.assertEquals(loginPage.getHeader(), "Login to CollabFlex");
    }

    @DataProvider(name = "IncorrectCredentials")
    public static Object[][] incorectCredentials() {
        return new Object[][] {
                { "aaa", "bbb"}};
    }

    @Test(dataProvider = "IncorrectCredentials")
    public void userCannotLoginWithIncorrectCredentials(String login,String password){
        loginPage.login(login,password);
        Assert.assertEquals(loginPage.getErrorValidationMsg(), "User not found. Please check login and password and try once again...");
    }


}

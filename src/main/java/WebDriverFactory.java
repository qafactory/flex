import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private static WebDriver webDriver = null;

    public static WebDriver getInstance(String browser) {

        if (webDriver != null) {
            return webDriver;
        }

        if (browser.equals("chrome")) {
            webDriver = new ChromeDriver();

        } else if (browser.equals("firefox")) {
            webDriver = new FirefoxDriver();

        } else if (browser.equals("ie")) {
            webDriver = new InternetExplorerDriver();

        } else {throw new Error("Unsupported browser");
        }

        return webDriver;
    }
}

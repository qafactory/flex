import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {


        public WebDriver webDriver;
        public WebDriverWait wait;

        public Page(WebDriver webDriver) {
            this.webDriver = webDriver;
            wait = new WebDriverWait(webDriver,10);
        }
}

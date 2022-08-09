package Steps;

import Pages.BasePage;
import Pages.MainMenu;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;


public class Hooks extends BasePage {
    public Hooks() {
        super(driver);
    }

    private String signOut = "//a[@title='Log me out']";

    MainMenu main = new MainMenu();

    @Before("@Checkout")
    public void cpCheckoutBefore() throws InterruptedException {
        idsDisplayed();
    }


    @Before("@ContactUs")
    public void cpContactUs() throws InterruptedException {
        idsDisplayed();
    }

    @Before("@WishList")
    public void cpWishList() throws InterruptedException {
        idsDisplayed();
    }

    private void idsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        try {
            if (findByXpath(signOut).isDisplayed()) {
                main.clicEnSignOut();
            }
        }catch (TimeoutException e){
            System.out.println("logout is not displayed");
        }
        Thread.sleep(2000);
    }

}
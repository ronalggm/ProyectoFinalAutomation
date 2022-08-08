package Steps;

import Pages.BasePage;
import Pages.MainMenu;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;


public class Hooks extends BasePage {
    public Hooks() {
        super(driver);
    }

    MainMenu main = new MainMenu();

    @Before("@Checkout")
    public void cpCheckoutBefore() throws InterruptedException {
        Thread.sleep(3000);
        main.clicEnSignOut();
        Thread.sleep(3000);
        //driver.navigate().refresh();
    }

    @Before("@PersonalInfo")
    public void cpPersonalInfo() throws InterruptedException {

    }
    @Before("@ContactUs")
    public void cpContactUs() throws InterruptedException {
        Thread.sleep(2000);
        main.clicEnSignOut();
        Thread.sleep(2000);
    }

    @Before("@WishList")
    public void cpWishList() throws InterruptedException {
        Thread.sleep(2000);
        main.clicEnSignOut();
        Thread.sleep(2000);
    }

}
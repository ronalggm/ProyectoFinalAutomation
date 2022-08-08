package Pages;

import org.openqa.selenium.WebDriver;

public class MyWishLists extends BasePage {
    //Locators
    private String myWishListList = "//a[normalize-space()='My wishlist']";
    private String removeListButton = "(//i[@class='icon-remove'])[1]";

    public MyWishLists() {
        super(driver);
    }

    public void clicEnMiLista() {
        clickElement(myWishListList);
    }
public void clicEnRemoveButtonList(){
        clickElement(removeListButton);
};

}

package Pages;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainMenu extends BasePage {
    public MainMenu() {
        super(driver);
    }

    //Locators Main Menu
    private String campoBusqueda = "//*[@id='search_query_top']";
    private String botonBuscar = "//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]";
    private String signIn = "//a[contains(text(),'Sign in')]";
    private String viewOnList = "//i[@class='icon-th-list']";
    private String contactenos = "//a[@title='Contact Us']";
    private String compareButton = "//div[@class='top-pagination-content clearfix']//span[1]";
    private String myAccount = "//a[@title='View my customer account']";
    private String myWishLists="//span[normalize-space()='My wishlists']";

    private String signOut="//a[@title='Log me out']";
    //METODOS (Acciones) Main Menu

    public void navegarAutomationPractice() {
        navegarA("http://automationpractice.com/index.php");
    }
    public void clicEnBarraBusqueda() {
        clickElement(campoBusqueda);
    }
    public void clicEnBusqueda() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(botonBuscar);
    }
    public void escribirNombreDeProducto(String texto) {
        write(campoBusqueda, texto);
    }
    public void clicEnSignIn() throws InterruptedException {
        Thread.sleep(400);
        clickElement(signIn);

    }
    public void clicEnBoton(String locator) {
        Awaitility.waitAtMost(6, TimeUnit.SECONDS);
        clickElement(locator);
    }
    public int clicEnAddToCompare(String locator) {
        clickElement(locator);
        int contador = 0;
        return contador++;
    }
    public void switchToProduct(int index) {switchToWindowsElement(index);}

    public void clicEnContactenos() throws InterruptedException {clickElement(contactenos);
        Thread.sleep(3000);
    }
    public void verEnLista() {clickElement(viewOnList);}
    public void clicEnCompare() throws InterruptedException {Thread.sleep(10000);
        clickElement(compareButton);
    }
    public void clicEnRemoveButon(String locator){clickElement(locator);}
    public void clicEnAccount() {clickElement(myAccount);}

    public void clicEnMyWishList(){clickElement(myWishLists);}
    public void clicEnSignOut(){
        clickElement(signOut);
}

}


package Steps;

import Pages.MainMenu;
import Pages.MyWishLists;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class WishListSteps {
    MainMenu mainMenu = new MainMenu();
    MyWishLists myLists = new MyWishLists();
    //-------------------Locators Validaciones
    private String product01WishList = "(//img[@alt='Printed Dress'])[1]";
    private String product02WishList = "(//img[@alt='Printed Summer Dress'])[1]";
    private String QuantityOfProducts = "//td[@class='bold align_center']";

    //-----------------productos para wishlist
    private String addWishListProduct01 = "//a[@class='addToWishlist wishlistProd_5']";
    private String addWishListProduct02 = "//a[@class='addToWishlist wishlistProd_4']";
    private String addedToWishListClose = "//a[@title='Close']";

    @And("Agrego dos productos a la Wish list")
    public void agregoDosProductosALaWishList() throws InterruptedException {
        mainMenu.verEnLista();
        Thread.sleep(2000);
        mainMenu.clicEnBoton(addWishListProduct01);
        Thread.sleep(2000);
        mainMenu.clicEnBoton(addedToWishListClose);
        mainMenu.clicEnBoton(addWishListProduct02);
        mainMenu.clicEnBoton(addedToWishListClose);
        Thread.sleep(3000);
        mainMenu.clicEnAccount();
        mainMenu.clicEnMyWishList();
        myLists.clicEnMiLista();
    }
    @Then("Valido que los productos se hayan agregado correctamente")
    public void validacionWishList01() {
        boolean producto01 = myLists.isDisplayed(product01WishList);
        boolean producto02 = myLists.isDisplayed(product02WishList);
        Assert.assertTrue("No se encuentra el producto01 en la wishList", producto01);
        Assert.assertTrue("No se encuentra el producto02 en la wishList", producto02);
    }

    @Then("Valido que la cantidad sea la correcta \\({int} productos)")
    public void validoQueLaCantidadSeaLaCorrectaProductos(int cantidad) {
        int resultado = Integer.parseInt(myLists.obtenerTexto(QuantityOfProducts));
        Assert.assertEquals("La cantidad no coincide con la esperada", cantidad, resultado);
    }

    @And("Valido que los nombres de los productos sean los correctos")
    public void validoQueLosNombresDeLosProductosSeanLosCorrectos(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> element : data) {
            if (myLists.isDisplayed("//p[contains(text(),'" + element.get("Nombres") + "')]")) {
                String result = myLists.obtenerTexto("//p[contains(text(),'" + element.get("Nombres") + "')]");

                myLists.clicEnRemoveButtonList();
                Assert.assertEquals("El nombre no coincide con el esperado", result, element.get("Nombres"));
                myLists.switchToAlertFrame();
                Thread.sleep(4000);
            }
        }
    }
}


package Steps;

import Pages.MainMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class BuscarProductosSteps {

    //-----------Objetos
    MainMenu mainMenu = new MainMenu();
    //-------------------Locators Validaciones
    private String cantidadBusqueda = "//span[@class='heading-counter']";
    private String nombeProducto = "//*[@id=\"center_column\"]/h1/span[1]";
    private String productoNoEncontrado = "//p[@class='alert alert-warning']";
    //-----------Productos--------------------------------------
    private String printedChifonDressIMG = "//img[@alt='Printed Chiffon Dress']";
    private String viewMyShoppingCart = "//a[@title='View my shopping cart']";
    private String addToCart = "//span[contains(text(),'Add to cart')]";
    private String continueTOshopping = "//span[@title='Continue shopping']//span[1]";

    //-------------------------------------------------------------------------
    @Given("Ingreso a la pagina web AutomationPractice")
    public void ingresoALaPaginaWebAutomationPractice() {
        mainMenu.navegarAutomationPractice();
    }

    @When("Escribo nombre de un producto {string}")
    public void escriboNombreDeUnProductoProducto(String producto) throws InterruptedException {
        Thread.sleep(2000);
        mainMenu.escribirNombreDeProducto(producto);
    }

    @And("Doy clic en el boton de busqueda")
    public void doyClicEnElBotonDeBusqueda() throws InterruptedException {
        Thread.sleep(600);
        mainMenu.clicEnBusqueda();
        Thread.sleep(3000);
    }

    @Then("Valido que aparezca {int} de elementos encontrado")
    public void ValidoCantidad(int cantidad) {
        String elementos = mainMenu.obtenerTexto(cantidadBusqueda);
        System.out.println("Resultado cantidad: " + elementos);
        String PrimerCaracter = String.valueOf(elementos.charAt(0));
        if (PrimerCaracter.contains("0")) {
            System.out.println("No se encontraron articulos");
            System.out.println("Mensaje: " + mainMenu.obtenerTexto(productoNoEncontrado));
        }
        int result = Integer.parseInt(PrimerCaracter);
        Assert.assertEquals("No se encontro elemento", result, cantidad);
    }

    @And("Valido que aparezca el nombre {string} en la pag")
    public void validoQueAparezcaElNombreNombreEnLaPag(String result) {
        String resulBusqueda = mainMenu.obtenerTexto(nombeProducto).replace("\"", "");
        if (resulBusqueda.contains("0")) {
            resulBusqueda = "";
        }
        System.out.println("Resultado espeado: " + result);
        System.out.println("Resultado obtenido: " + resulBusqueda);
        Assert.assertEquals("No se encontro elemento", result, resulBusqueda);
    }

    @And("Agrego un producto al carrito")
    public void agregoUnProductoAlCarrito() throws InterruptedException {
        mainMenu.clicEnBoton(printedChifonDressIMG);
        mainMenu.switchToProduct(0);
        mainMenu.clicEnBoton(addToCart);
        Thread.sleep(500);

    }

    @And("Agrego los siguientes productos al carrito")
    public void agregoLosSiguientesProductosAlCarrito(DataTable tableProducts) throws InterruptedException {
        List<Map<String, String>> data = tableProducts.asMaps(String.class, String.class);
        mainMenu.verEnLista();
        int contador = 0;
        int indexAddButton=1;
        for (Map<String, String> elementos : data) {
            System.out.println("Agrado al carrito: " + data.get(contador).get("Productos"));
            if (mainMenu.isDisplayed("(//img[@title='" + data.get(contador).get("Productos") + "'])[1]")) {
                Thread.sleep(2000);
                //  mainMenu.clickAndHold("(//img[@title='" + data.get(contador).get("Productos") + "'])[1]");

                mainMenu.clickAndHold("(//span[contains(text(),'Add to cart')])["+indexAddButton+"]");
             //   mainMenu.switchToProduct(0);
                Thread.sleep(2000);
              //  mainMenu.clickAndHold(addToCart);
                Thread.sleep(2000);
              //  mainMenu.switchToParentFrame();
                mainMenu.clicEnBoton(continueTOshopping);
                //   mainMenu.goBack();
                contador++;
                indexAddButton++;
            }
        }
        mainMenu.clicEnBoton(viewMyShoppingCart);

    }

}






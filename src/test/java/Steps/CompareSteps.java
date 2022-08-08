package Steps;

import Pages.MainMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class CompareSteps {
    MainMenu mainMenu=new MainMenu();
    //-------------------Locators Validaciones
    private String comparasionLocation = "//div[@class='breadcrumb clearfix']";

    //-----------Productos, comparacion
    private ArrayList<Integer> elementosAcomparar = new ArrayList<>();
    private String printedSummerDressIMG = "//img[@alt='Printed Summer Dress']";
    private String printedChifonDressIMG = "//img[@alt='Printed Chiffon Dress']";
    private String addcompare01 = "(//a[@class='add_to_compare'][normalize-space()='Add to Compare'])[1]";
    private String addCompare02 = "(//a[@class='add_to_compare'][normalize-space()='Add to Compare'])[2]";
    private String contadorButton = "//div[@class='top-pagination-content clearfix']//strong[1]";

    @When("Busco algunos productos y los agrego para comparar")
    public void buscarAlgunosProductosyAgregarlos() throws InterruptedException {
        mainMenu.clicEnBarraBusqueda();
        mainMenu.escribirNombreDeProducto("printed");
        mainMenu.clicEnBusqueda();
        mainMenu.verEnLista();
        int producto1 = mainMenu.clicEnAddToCompare(addcompare01);

        Thread.sleep(1000);
        int producto2 = mainMenu.clicEnAddToCompare(addCompare02);
        Thread.sleep(1000);
        elementosAcomparar.add(producto1);
        elementosAcomparar.add(producto2);
        Thread.sleep(1000);
    }

    @And("Doy clic en el boton compare")
    public void doyClicEnElBotonCompare() throws InterruptedException {
        mainMenu.clicEnCompare();
    }

    //----------------------Validaciones----------------------------
    @Then("Verifico que la cantidad coincide correctamente")
    public void verificoQueLaCantidadCoincideCorrectamente() {
        int expResult = elementosAcomparar.size();
        String resultTexto = mainMenu.obtenerTexto(contadorButton);
        int result = Integer.parseInt(resultTexto);
        System.out.println("Cantidad de elementos agregados para comparar: " + elementosAcomparar.size());
        System.out.println("Cantidad que indica el boton de comparacion: " + result);

        Assert.assertEquals("Los elementos agregados no coinciden con la cantidad que se muestra", expResult, result);

    }
    @Then("Verifico que se comparen correctamente")
    public void verificoQueSeComparenCorrectamente() throws InterruptedException {
        String expResult = "> Product Comparison";
        String result = mainMenu.obtenerTexto(comparasionLocation);
        System.out.println("Pagina situada: " + result);
        System.out.println("Pagina esperada: " + expResult);
        boolean producto1 = mainMenu.isDisplayed(printedChifonDressIMG);
        boolean producto2 = mainMenu.isDisplayed(printedSummerDressIMG);
        Assert.assertTrue("No se encuentra el producto01 para comparar", producto1);
        Assert.assertTrue("No se encuentra el producto02 para comparar", producto2);
        for (int elementos : elementosAcomparar) {
            int conunt = 0;
            conunt++;
            mainMenu.clicEnRemoveButon("(//i[@class='icon-trash'])" + "[" + conunt + "]");

        }
   Thread.sleep(2000);
    }
}

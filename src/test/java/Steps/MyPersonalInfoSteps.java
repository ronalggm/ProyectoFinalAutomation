package Steps;

import Pages.PersonalInformation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class MyPersonalInfoSteps {
    PersonalInformation info = new PersonalInformation();
    //----------Locators validaciones------------------
    private String messagePersonalInfoChange = "//p[@class='alert alert-success']";

    @When("Ingreso a mis datos personales")
    public void ingresoAMisDatosPersonales() throws InterruptedException {
        Thread.sleep(3000);
        info.clicOnMyPersonalInformation();
    }


    @And("Modifico mis datos personales por los siguientes")
    public void modificoMisDatosPersonalesPorLosSiguientes(DataTable table) throws InterruptedException {
        Map<String, String> infotable = table.asMap();
        Thread.sleep(2000);
        info.clicOnRadioMrs();
        //--------------------------------------------------
        info.writeFirstName(infotable.get("First name"));
        info.writeLastName(infotable.get("Last name"));
        Thread.sleep(3000);
        //----------------------------------------------------------
        info.seleccionarDia("//option[@value='11']");
        info.seleccionarMes("//select[@id='months']//option[@value='11']");
        info.seleccionarAno("//option[@value='1993']");
        info.writeCurrentPassword("123456");
        info.clicOnSaveButton();
    }
    @Then("Verifico que se visualice {string}")
    public void verificoQueSeVisualice(String message) {
        String result = info.obtenerTexto(messagePersonalInfoChange);
        String expResult = message;
        Assert.assertEquals("El mensaje no aparece en pantalla",result,expResult);
    }


}


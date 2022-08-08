package Steps;

import Pages.ContactUs;
import Pages.MainMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class ContactUsSteps {
    //------Objetos---------
    MainMenu menu = new MainMenu();
    ContactUs contact = new ContactUs();
    private String messajeSend="//*[@id=\"center_column\"]/p";

    @And("Doy clic en contactenos")
    public void doyClicEnContactenos() throws InterruptedException {
             Thread.sleep(1000);
            menu.clicEnContactenos();
            Thread.sleep(1000);

    }
    @When("Completo los siguientes campos")
    public void completoLosCampos(DataTable dataTable){
        List<List<String>> contactData = dataTable.asLists(String.class);
        contact.clicEnCabezera();
        contact.clicEnCustomerService();
        contact.clicEnEmailAdress();
        contact.esribirEnEmailAdress(contactData.get(1).get(0));
        contact.clicEnOrderReference();
        contact.escribirEnOrderReference(contactData.get(1).get(1));
        contact.clicEnMessage();
        contact.escribirEnMessage(contactData.get(1).get(2));
    }
    @And("Doy Clic en el boton Send")
    public void doyClicEnElBotonSend() {contact.clicEnSendButton();}

    @Then("Valido que el mensaje haya sido enviado exitosamente")
    public void validacionMensajeEnviado() {
        String expectedResult="Your message has been successfully sent to our team.";
        Assert.assertEquals("el Mensaje no fue enviado",expectedResult,contact.obtenerTexto(messajeSend));
    }
}

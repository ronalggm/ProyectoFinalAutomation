package Steps;

import Pages.BasePage;
import Pages.MainMenu;
import Pages.SignIn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class SignInSteps {
    //Objetos
    SignIn login = new SignIn();
    MainMenu menu = new MainMenu();


    @Given("Doy clic en signIn me logueo con usuario y contrasena correctas")
    public void meLogueConUsuarioYContrasena(DataTable userData) throws InterruptedException {
        List<Map<String, String>> data = userData.asMaps(String.class, String.class);
   boolean verif=login.seVeLogout();

       if (verif!=true) {
           Thread.sleep(3000);
           menu.clicEnSignIn();
           login.clicEmailAdress();
           login.escbribirEmail(data.get(0).get("Usuario"));
           login.clicPassword();
           login.escribirEnPassword(data.get(0).get("Password"));
           login.clicEnBotonSignIn();

       }
    }
    @Then("verifico que este logueado")
    public void verificoQueEsteLogueado() {
        Assert.assertTrue("El usuario no esta logueado", login.seVeLogout());
    }


}

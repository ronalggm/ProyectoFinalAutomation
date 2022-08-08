package Steps;

import Pages.CheckOut;
import Pages.MainMenu;
import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class checkOutSteps {

    //Objetos
    CheckOut chekOut = new CheckOut();
    //Locators
    private String validationForCheck = "//p[contains(text(), 'Your order on My Store is complete.')]";
    private String validationForWire = "//*[@id='center_column']/div/p/strong";
    String camino = null;
    @And("Realizo el checkout con {string}")
    public String realizoElCheckoutCon(String medioPago) throws InterruptedException {
        selectCheckout(); //Metodo con pasos genericos para los dos pasos
        switch (medioPago) {
            case "Pay By check":
                camino = "Cheque";
                chekOut.clicOnPayByCheck();
                chekOut.clicOnIConfirmMyOrderCheque();
                break;
            case "Transferencia":
                camino = "Transferencia";
                chekOut.clicOnPayByWire();
                chekOut.clicProceedToCheckoutwire();
                break;
        }
        return camino;
    }
    private void selectCheckout() throws InterruptedException {
        Thread.sleep(200);
        chekOut.switchToMain();
       // chekOut.clicProceedToCheckout1(); //locator de producto individual
        chekOut.clicProceedToCheckout2();
        chekOut.clicProceedToCheckout3();
        chekOut.clicTermsAndConditions();
        chekOut.clicProceedToCheckout4();
    }
    @Then("Valido que la compra fue exitosa para {string}")
    public void confirmoQueLaCompraFueExitosa(String option) {
        boolean result = false;
        switch (option) {
            case "Cheque":
                result = chekOut.yourOrderisCompleted(validationForCheck);
                break;

            case "Transferencia":
                result = chekOut.yourOrderisCompleted(validationForWire);
                break;
        }
        Assert.assertTrue("La compra no fue Exitosa", result);
        System.out.println("Your order on My Store is complete.");
    }
}



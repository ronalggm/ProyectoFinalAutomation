package Pages;


import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class ContactUs extends BasePage {
    public ContactUs() {
        super(driver);
    }

    //--------Locators
    private String subjetHeading = "//div[@id='uniform-id_contact']";

    private String intoSubjetHeading="//*[@id=\"id_contact\"]";
    private String subjetValueCustomer = "2";
    private String customerService="//option[contains(text(),'Customer service')]";
    private String emailAdress = "//input[@id='email']";
    private String orderReference = "//input[@id='id_order']";
    private String message = "//textarea[@id='message']";
    private String sendButton = "//span[contains(text(), 'Send')]";

    //--------Metodos
    public void clicEnCabezera() {
        clickElement(subjetHeading);
    }
    public void clicEnCustomerService(){
        clickElement(customerService);
    }
    public void SeleccionarCabezera() {selectFromDropDown(subjetHeading, subjetValueCustomer);}

    public void clicEnEmailAdress() {clickAndHold(emailAdress);}

    public void esribirEnEmailAdress(String text)

    {write(emailAdress, text);}

    public void clicEnOrderReference() {
        clickAndHold(orderReference);
    }

    public void escribirEnOrderReference(String text) {
        write(orderReference, text);
    }

    public void clicEnSendButton() {
        clickElement(sendButton);
    }

    public void clicEnMessage() {
        clickElement(message);
    }

    public void escribirEnMessage(String text) {write(message, text);}

}
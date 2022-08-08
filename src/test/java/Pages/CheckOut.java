package Pages;

public class CheckOut extends BasePage {

    public CheckOut() {
        super(driver);
    }
    //--------Locators
    private String checkOutButton1 = "//a[@title='Proceed to checkout']";
    private String checkOutButton2="//*[@id='center_column']/p[2]/a[1]/span";
    private String checkOutButton3="//*[@id='center_column']/form/p/button/span";
    private String checkOutButton4="//*[@id='form']/p/button/span";
    private String checkOutButtonWire="//*[@id='cart_navigation']/button/span";
    private String checkBoxTerms="//label[text()='I agree to the terms of service and will adhere to them unconditionally.']";
    private String payByWire = "//a[@class='bankwire']";
    private String payByCheck = "//a[@class='cheque']";
    private String iConfirmMyOrdercheck = "//span[contains(text(), 'I confirm my order')]";
    //------------------Metodos
    public void clicProceedToCheckout1() {
        clickElement(checkOutButton1);
    }//locator para un solo producto
    public void clicProceedToCheckout2() {
        clickElement(checkOutButton2);
    }
    public void clicProceedToCheckout3(){
        clickElement(checkOutButton3);
    }
    public void clicProceedToCheckout4(){clickElement(checkOutButton4);}
    public void clicProceedToCheckoutwire(){clickElement(checkOutButtonWire);}
    public void clicTermsAndConditions()  {clickElement(checkBoxTerms);}
    public void clicOnPayByCheck() {
        clickElement(payByCheck);
    }
    public void clicOnPayByWire() {
        clickElement(payByWire);
    }
    public void clicOnIConfirmMyOrderCheque() {
        clickElement(iConfirmMyOrdercheck);
    }
    public boolean yourOrderisCompleted(String locator) {
        return  isDisplayed(locator);
    }
    public void switchToMain() {switchToParentFrame(); } //volver al foco principal

}

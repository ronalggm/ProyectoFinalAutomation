package Pages;

public class SignIn extends BasePage {
    public SignIn() {
        super(driver);
    }
    //LOCTATORS:
    private String campoEmail = "//input[@id='email']";
    private String campoPassword = "//input[@id='passwd']";
    private String botonSignIn = "//i[@class='icon-lock left']";
    private String singOut="//a[@title='Log me out']";
private String SingIn="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a";
    //METODOS:
    public void irAinicioDeSesion() {
        navegarA("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    public void clicEmailAdress() {
        clickElement(campoEmail);
    }
    public void clicPassword() {
       clickAndHold(campoPassword);
    }
    public void clicEnBotonSignIn() {

        clickElement(botonSignIn);
    }
    public void escbribirEmail(String email) {
        write(campoEmail, email);
    }
    public void escribirEnPassword(String password) {
        write(campoPassword, password);
    }

  //-----------------validaciones
    public boolean seVeLogout() {
        return isDisplayed(singOut);}

    //--------------------------------------------------------------------

}



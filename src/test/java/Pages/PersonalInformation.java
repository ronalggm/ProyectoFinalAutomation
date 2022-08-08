package Pages;


public class PersonalInformation extends BasePage {
    public PersonalInformation() {
        super(driver);
    }

    private String personalInformationButton = "//span[contains(text(),'My personal information')]";
    private String radioButtonMrs = "//div[@id='uniform-id_gender2']";
    private String firstNameField = "//input[@id='firstname']";
    private String lastNameField = "//input[@id='lastname']";
    private String dayDropDown = "//div[@id='uniform-days']"; //cambiar por select luego
    private String monthDropDown = "//div[@id='uniform-months']"; //cambiar por select
    private String yearDropDown = "//div[@id='uniform-years']"; //cambiar por select
    private String currentPasswordField = "//input[@id='old_passwd']";
    private String saveButton = "//span[normalize-space()='Save']";

    public void clicOnMyPersonalInformation() {
        clickElement(personalInformationButton);
    }

    public void clicOnRadioMrs() {
        clickElement(radioButtonMrs);
    }

    public void writeFirstName(String name) {
        clickElement(firstNameField);
        write(firstNameField, name);
    }

    public void writeLastName(String lastName) {
        clickElement(lastNameField);
        write(lastNameField, lastName);
    }
    public void writeCurrentPassword(String password) {
        clickElement(currentPasswordField);
        write(currentPasswordField, password);
    }
    public void clicOnSaveButton() {
        clickElement(saveButton);
    }
    public void seleccionarDia(String option) {
        clickElement(dayDropDown);
        clickElement(option);
    }
    public void seleccionarMes(String option) {
        clickElement(monthDropDown);
        clickElement(option);
    }

    public void seleccionarAno(String option) {
        clickElement(yearDropDown);
        clickElement(option);
    }

}

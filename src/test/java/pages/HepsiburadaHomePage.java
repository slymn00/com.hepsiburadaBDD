package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaHomePage {
    public HepsiburadaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement girisYap;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement loginButtonOnTheLoginPage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[text()='Telefon']")
    public WebElement telefonDropDown;

    @FindBy(xpath = "//div[text()='Cep Telefonu']")
    public WebElement ceptelefonu;

    @FindBy(xpath = "//div[@class='searchResultSummaryBar-mainText']")
    public WebElement aramaSonucuText;

    @FindBy(xpath = "(//h3[@data-test-id='product-card-name'])[26]")
    public WebElement arananUrun;

    @FindBy(xpath = "(//div[@data-test-id='product-image-right-bar-container'])[26]")
    public WebElement begenButonu;

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement hesabim;

    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    public WebElement begendiklerim;

    @FindBy(xpath = "(//h3[@data-test-id='product-card-name'])[1]")
    public WebElement begendiklerimUrun;

    @FindBy(xpath = "//div[text()='Sepete ekle']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    public WebElement urunSepeteEklendiPopUp;

    @FindBy(xpath = "//span[text()='Sepetim']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//a[@aria-label='Ürünü Kaldır']")
    public WebElement urunuKaldir;

    @FindBy(xpath = "(//button[@kind='primary'])[2]")
    public WebElement secilenleriKaldir;

    @FindBy(xpath = "//span[text()='Ürün sepetinizden silinmiştir']")
    public WebElement urununSilindiginiDogrulama;

}

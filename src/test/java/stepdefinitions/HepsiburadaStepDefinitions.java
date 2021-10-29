package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HepsiburadaHomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HepsiburadaStepDefinitions {

    HepsiburadaHomePage hepsiburadaHomePage=new HepsiburadaHomePage();

    @Given("Hepsiburada sitesi acilacak ve anasayfanin acildigini onaylayacak")
    public void hepsiburada_sitesi_acilacak_ve_anasayfanin_acildigini_onaylayacak(){
        Driver.getDriver().get(ConfigurationReader.getProperty("hepsiburada_url"));
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigurationReader.getProperty("expected_url"));
    }


    @And("Login ekranini acip, bir kullanici ile login olacak")
    public void login_ekranini_acip_bir_kullanici_ile_login_olacak() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiburadaHomePage.girisYap).perform();
        ReusableMethods.waitFor(3);
        actions.click(hepsiburadaHomePage.login).perform();
        ReusableMethods.waitFor(5);
        hepsiburadaHomePage.emailTextBox.sendKeys(ConfigurationReader.getProperty("hepsiburada_email"));
        hepsiburadaHomePage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("hepsiburada_password"));
        ReusableMethods.waitFor(5);
        hepsiburadaHomePage.loginButtonOnTheLoginPage.click();
    }

    @And("Ekranin ustundeki Search alanina samsung yazip Ara butonuna tiklayacak")
    public void ekranin_ustundeki_search_alanina_samsung_yazip_ara_butonuna_tiklayacak() {
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.searchBox.sendKeys(ConfigurationReader.getProperty("aranan_kelime")+ Keys.ENTER);
        ReusableMethods.waitFor(2);
    }


    @Then("Sol menuden Telefon sonrasinda Cep Telefonu tiklayacak")
    public void sol_menuden_telefon_sonrasinda_cep_telefonu_tiklayacak() {
        hepsiburadaHomePage.telefonDropDown.click();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.ceptelefonu.click();
    }


    @And("Gelen sayfada samsung icin sonuc bulundugunu onaylayacak")
    public void gelen_sayfada_samsung_icin_sonuc_bulundugunu_onaylayacak() {
        System.out.println(hepsiburadaHomePage.aramaSonucuText.getText());
        Assert.assertTrue(hepsiburadaHomePage.aramaSonucuText.getText().contains(ConfigurationReader.getProperty("aranan_kelime")));

    }

    @And("Yirmialtinci siradaki urunun uzerine gelecek")
    public void yirmialtinci_siradaki_urunun_uzerine_gelecek() {
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(hepsiburadaHomePage.arananUrun).perform();
        ReusableMethods.waitFor(4);
    }

    @Then("Urun detayinda Begen butonuna tiklayacak")
    public void urun_detayinda_begen_butonuna_tiklayacak() {
        hepsiburadaHomePage.begenButonu.click();
        ReusableMethods.waitFor(2);

    }

    @And("Ekranin en ustundeki hesabim alaninda Begendiklerime tiklayacak")
    public void ekranin_en_ustundeki_hesabim_alaninda_begendiklerim_tiklayacak() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(2);
        actions.moveToElement(hepsiburadaHomePage.hesabim).perform();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.begendiklerim.click();
    }

    @And("Acilan sayfada bir onceki sayfada begendiklerime alinmis urunun bulundugunu onaylayacak")
    public void acilan_sayfada_bir_onceki_sayfada_begendiklerime_alinmis_urunun_bulundugunu_onaylayacak() {
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();
        String begendiklerimdekiUrun=hepsiburadaHomePage.begendiklerimUrun.getText();
        Assert.assertTrue(begendiklerimdekiUrun.contains("Samsung"));
    }


    @Then("Begendiklerime alinmis urun bulunup secilecek ve sepete eklenecek")
    public void begendiklerimeAlinmisUrunBulunupSecilecekVeSepeteEklenecek() {
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);
        actions.moveToElement(hepsiburadaHomePage.begendiklerimUrun).perform();
        ReusableMethods.waitFor(1);
        actions.click(hepsiburadaHomePage.sepeteEkle).perform();

    }

    @And("Urun sepete eklendi' popup kontrolu yapacak")
    public void urun_sepeteEklendi_popup_kontrolu_yapacak() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(hepsiburadaHomePage.urunSepeteEklendiPopUp.isDisplayed());
    }

    @And("Sepetim sayfasina gidecek")
    public void sepetim_sayfasina_gidecek() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(6);
        hepsiburadaHomePage.sepetimButonu.click();
    }

    @Then("Sepete eklenen bu urunun icine girilip kaldir butonuna basilacak, sepetimden cikarilacak")
    public void sepete_eklenen_bu_urunun_icine_girilip_kaldir_butonuna_basilacak_sepetimden_cikarilacak() {
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.urunuKaldir.click();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.secilenleriKaldir.click();
        ReusableMethods.waitFor(1);
        hepsiburadaHomePage.urunuKaldir.click();
    }

    @And("Bu urunun artik sepette olmadigini onaylayacak")
    public void bu_urunun_artik_sepette_olmadigini_onaylayacak() {
        ReusableMethods.waitFor(2);
        String urununsilindiginidogrulama=hepsiburadaHomePage.urununSilindiginiDogrulama.getText();
        System.out.println(urununsilindiginidogrulama);
        Assert.assertTrue(urununsilindiginidogrulama.contains("silin"));
    }
    @And("Sol ust kosedeki logo ile anasayfaya gecis yapilacak")
    public void sol_ust_kosedeki_logo_ile_anasayfaya_gecis_yapilacak() {
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.sepetBolumundekiHepsiburadaLogosu.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigurationReader.getProperty("hepsiburada_url"));

    }
    @Then("Sayfanin sonuna dogru inip cagri merkezi numarasini kontrol edecek")
    public void sayfanin_sonuna_dogru_inip_cagri_merkezi_numarasini_kontrol_edecek() {
        ReusableMethods.waitFor(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END)
                .sendKeys(Keys.PAGE_UP)
                .perform();
        Assert.assertEquals(hepsiburadaHomePage.cagriMerkeziNo.getText(),ConfigurationReader.getProperty("cagrimerkezi_No"));


    }
    @Then("Sag alt kisimdaki Basa don yazisi ile sayfanin basina donecek")
    public void sag_alt_kisimdaki_basa_don_yazisi_ile_sayfanin_basina_donecek() {
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.basaDonYazisi.click();

    }

    @And("Sayfanin basina gelip Hepsiburada logosunun gorundugunu kontrol edecek")
    public void sayfanin_basina_gelip_hepsiburada_logosunun_gorundugunu_kontrol_edecek() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(hepsiburadaHomePage.anasayfadakiHepsiburadaLogosu.isDisplayed());

    }
    @Then("Ekranin en ustundeki hesabim alanina gelecek cikis yapa tiklayacak")
    public void ekranin_en_ustundeki_hesabim_alanina_gelecek_cikis_yap_a_tiklayacak() {
        ReusableMethods.waitFor(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiburadaHomePage.hesabim).perform();
        ReusableMethods.waitFor(1);
        actions.click(hepsiburadaHomePage.cikisYapButonu).perform();
    }
    @Then("Cikis yaptigini kontrol edecek")
    public void cikis_yaptigini_kontrol_edecek() {
        ReusableMethods.waitFor(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiburadaHomePage.girisYap).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(hepsiburadaHomePage.login.isDisplayed());
    }

    @And("Site kapanacak")
    public void site_kapanacak() {
        Driver.closeDriver();
    }



}

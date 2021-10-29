Feature:
  @hepsiburada
  Scenario:
    Given  Hepsiburada sitesi acilacak ve anasayfanin acildigini onaylayacak
    And Login ekranini acip, bir kullanici ile login olacak
    And Ekranin ustundeki Search alanina samsung yazip Ara butonuna tiklayacak
    Then Sol menuden Telefon sonrasinda Cep Telefonu tiklayacak
    And Gelen sayfada samsung icin sonuc bulundugunu onaylayacak
    And Yirmialtinci siradaki urunun uzerine gelecek
    Then  Urun detayinda Begen butonuna tiklayacak
    And Ekranin en ustundeki hesabim alaninda Begendiklerime tiklayacak
    And  Acilan sayfada bir onceki sayfada begendiklerime alinmis urunun bulundugunu onaylayacak
    Then Begendiklerime alinmis urun bulunup secilecek ve sepete eklenecek
    And Urun sepete eklendi' popup kontrolu yapacak
    And Sepetim sayfasina gidecek
    Then Sepete eklenen bu urunun icine girilip kaldir butonuna basilacak, sepetimden cikarilacak
    And Bu urunun artik sepette olmadigini onaylayacak
    And Sol ust kosedeki logo ile anasayfaya gecis yapilacak
    Then Sayfanin sonuna dogru inip cagri merkezi numarasini kontrol edecek
    Then Sag alt kisimdaki Basa don yazisi ile sayfanin basina donecek
    And Sayfanin basina gelip Hepsiburada logosunun gorundugunu kontrol edecek
    Then Ekranin en ustundeki hesabim alanina gelecek cikis yapa tiklayacak
    Then Cikis yaptigini kontrol edecek
    And Site kapanacak
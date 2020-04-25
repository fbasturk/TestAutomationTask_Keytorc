# Test Automation Task

Bu projede Keytorc tarafından verilen task oluşturulmuş olup senaryoların Page Object Model kullanılarak koşulması sağlanmıştır. Test projesinin başlatılması için `src/test/java/bsturk/tests/BaseTest.java` dosyasını JUnit ile çalıştırılmalıdır. 

## Proje Özellikleri
* Webdriver olarak Firefox driveri(geckodriver.exe) kullanılmıştır.
* Webdriver ları projede eklenmiştir. Versiyon uyuşmazlığında webdriverlar aynı isim ile `src/test/resources/` altında güncellenmelidir.
* Güvenlik protokollerinde engellemelere karşın firefox üzerinde profil oluşturulmuştur. Bu profil projeye `src/test/resources/` dosyasının altına eklenmiştir. Bu profil webdriver ayarlarına eklenerek çalıştırılmıştır. Profil dosyasında hatalara karşın yeni bir profil oluşturulduktan sonra `src/test/java/bsturk/utils/CreateDriverUtil.java` dosyasındaki `FirefoxProfile profile = new FirefoxProfile(new File("src/test/resources/s2exvbv4.user"));` metodu düzenlenmelidir.
* Projenin log kaydı tutulmaktadır. Log kaydı error, info ve benzeri başlıklar için ayrı ayrı tutulmaktadır. Log kayıtları `Logs/` altında zamana göre tutulmaktadır.

## Keytorc Task İsterleri
1.	http://www.n11.com<http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak
2.	Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )
3.	Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak 
4.	Gelen sayfada samsung icin sonuc bulundugunu onaylayacak 
5.	Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak
6.	Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak 
7.	Ekranin en ustundeki 'favorilerim' linkine tiklayacak 
8.	Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak
9.	Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak
10.	Sayfada bu urunun artik favorilere alinmadigini onaylayacak.  

## Test Log Çıktısı

    1- Keytorc's N11 test scenario begins.
    2- Browser Name: FIREFOX is getting ready to run.
    3- Browser Name: FIREFOX: N11 tests started.
    4- WebDriver created for N11 Tests
    5- Starting test scenarios in N11 Tests
        5.1- HomePage test scenario in N11 Tests
            HomePage test created for N11 Tests
                 1. Step: Visiting 'Homepage'
                 2. Step: Clicking the 'OK' button for closing GDPR popup
                     ---> Current Window State       : complete
                     Bypass the GDPR popup
                 3. Step: Checking 'Homepage' visit
                 4. Step: Clicking the 'Login' button
            HomePage test completed for N11 Tests

        5.2- LoginPage test scenario in N11 Tests
            LoginPage test created for N11 Tests
                 1. Step: Email address is writing to email area
                     ---> Current Window State       : complete
                 2. Step: Password is writing to password area
                 3. Step: Clicking the 'Login' button
            LoginPage test completed for N11 Tests

        5.3- HomePageWithLogin test scenario in N11 Tests
            HomePage test created for N11 Tests
                 1. Step: The given item 'samsung' is writing to search bar.
                     ---> Current Window State       : complete
                 2. Step: Clicking the 'Search' button
            HomePageWithLogin test completed for N11 Tests

        5.4- SearchPage test scenario in N11 Tests
            SearchPage test created for N11 Tests
                 1. Step: Checking is there a result for the searched item
                     ---> Current Window State       : complete
                 2. Step: Scrolling down to pages area
                 3. Step: Clicking the 'Second Page' button
                 4. Step: Checking the opening status of 'Second Page'
                     ---> Current Window State       : complete
                 5. Step: Scrolling down to reach list of items
                 6. Step: Adding the third item to 'My Favorites'
                 7. Step: Clicking the 'OK' button for closing the popup
                     Bypass the popup
                 8. Step: Scrolling up to 'My Account' button
                 9. Step: Clicking the 'My Favorites / Lists' button
            SearchPage test completed for N11 Tests

        5.5- WishListPage test scenario in N11 Tests
            MyWishListPage test created for N11 Tests
                 1. Step: Clicking the 'My Favorites List'
                     ---> Current Window State       : complete
            MyWishListPage test completed for N11 Tests

        5.6- MyFavoritesPage test scenario in N11 Tests
            MyFavoritesPage test created for N11 Tests
                 1. Step: Checking the selected item added status to 'Favorites'
                     ---> Current Window State       : complete
                 2. Step: Deleting the selected item from 'Favorites'
                 3. Step: Clicking the 'OK' button for closing the popup
                 4. Step: Checking the selected item deleted status from 'Favorites'
                     ---> Current Window State       : interactive
                     ---> Current Window State       : interactive
                     ---> Current Window State       : interactive
                     ---> Current Window State       : complete
            MyFavoritesPage test completed for N11 Tests

    6- Test Complete Time:72491, Browser Name: FIREFOX is closed


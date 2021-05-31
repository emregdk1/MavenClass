package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
    public static void main(String[] args) {

        /*
        1-Test01 isimli bir class olusturun
        2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4-Sayfayi “refresh” yapin
        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin

         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://walmart.com");
        driver.navigate().refresh();

        String walmartTitle = driver.getTitle();
        System.out.println("walmart Title : " + walmartTitle);

        if (walmartTitle.contains("Save")) {
            System.out.println("girdiginiz kelimeyi iceriyor");
        }
        else {
            System.out.println("girdiginiz kelimeyi icermiyor");
        }

        String walmartBaslik = driver.getTitle();
        System.out.println("walmart Baslik : " + walmartBaslik);

        if (walmartBaslik.equals("Walmart.com | Save Money.Live Better")) {
            System.out.println("iceriyor");
        }
        else {
            System.out.println("icermiyor");
        }

        String walmartUrl = driver.getCurrentUrl();
        System.out.println("walmart URL'si : " + walmartUrl);

        if (walmartUrl.contains("walmart.com")) {
            System.out.println("iceriyor");
        }
        else {
            System.out.println("icermiyor");
        }

        WebElement aramaKutusu = driver.findElement(By.id("global-search-input"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        WebElement aramaSonuc =  driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(aramaSonuc.getText());

        driver.quit();






















    }
}

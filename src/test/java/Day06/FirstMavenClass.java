package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        // Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiWebElementi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiWebElementi.getText());
        // sadece sonuc adedini istersek sonuc yazisini String'e atayip string manipulation yapabiliriz

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // geri giderek arama sayfasindaki tüm basliklari yazdiralim

        driver.navigate().back();

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement w : basliklarListesi ) {
            System.out.println("Tum basliklar : " + w.getText());
        }

        driver.close();





    }

}

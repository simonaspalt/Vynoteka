import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.color.ICC_ColorSpace;
import java.util.Random;
import java.util.concurrent.TimeUnit;
//Vynoteka: Patvirtinti amžių, patikrinti ar palaukus iššoka langas siūlydamas subscribe'inti.
//2 testas: atvirtinti amžių, patikrinti ar palaukus iššoka reklaminis langas. Po to kai atmetam langa subscribe.
//3. Ištestuoti paiešką - t.y patikrinti paiešką ar randamos prekės.
//4. Sukurti naują vartotojo paskyrą - iki telefono nr patikrinimo

public class TestClassVynoteka {
    WebDriver _globalDriver;


    @BeforeTest
    public  void WebDriverSetUp(){
        _globalDriver = new ChromeDriver();}

    @Test
    public void TestVyno1(){
        _globalDriver.get("https://vynoteka.lt/");

        WebElement ageVerification = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerification.click();

        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement adPop = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/a/img[1]"));
        Assert.assertNotNull(adPop);




    }

    @Test
    public void TestVyno2(){
        _globalDriver.get("https://vynoteka.lt/");

        WebElement ageVerifi = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerifi.click();

        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        try {
            TimeUnit.SECONDS.sleep(35);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adSubClose = _globalDriver.findElement(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon"));
        adSubClose.click();

        try {
            TimeUnit.SECONDS.sleep(35);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adPop = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/a/img[1]"));
        Assert.assertNotNull(adPop);

    }

    @Test
    public void TestVyno3(){
        _globalDriver.get("https://vynoteka.lt/");

        WebElement ageVerifi = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerifi.click();

        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        WebElement searchBar = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input"));
        searchBar.sendKeys("Midus");
        searchBar.submit();



    }

}

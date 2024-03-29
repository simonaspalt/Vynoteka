import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.color.ICC_ColorSpace;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
//Vynoteka: Patvirtinti amžių, patikrinti ar palaukus iššoka langas siūlydamas subscribe'inti.
//2 testas: atvirtinti amžių, patikrinti ar palaukus iššoka reklaminis langas. Po to kai atmetam langa subscribe.
//3. Ištestuoti paiešką - t.y patikrinti paiešką ar randamos prekės.
//4. Sukurti naują vartotojo paskyrą - iki telefono nr patikrinimo
//5. Prekės įsidėjimas į krepšelį, visų duomenų pristatymui suvedimas.
// Vėliau -> peržiūrėti krepšelį, įsitikinti, kad jame yra būtent ta prekė, už būtent tą kainą, kurią pridėjome.

public class TestClassVynoteka {
    WebDriver _globalDriver;
    private WebDriver globalDriver;
    //@BeforeTest
    //public void SetupWebDriver() {
    //    ChromeOptions options = new ChromeOptions();
    //    options.addArguments("--start-maximized");
    //    _globalDriver = new ChromeDriver(options);
    //    _globalDriver.get("https://vynoteka.lt/");
    //    _globalDriver.manage().window().maximize();
    //}


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
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        WebElement searchBar = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input"));
        searchBar.sendKeys("Midus");
        searchBar.submit();
       // _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/button")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement searchItem = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div/div/a"));
        Assert.assertNotNull(searchItem);

    }

    @Test
    public void TestVyno4(){
        _globalDriver.get("https://vynoteka.lt/");

        WebElement ageVerifi = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerifi.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        WebElement logButton = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button"));
        logButton.click();

        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement regButton = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div[1]/div/button"));
        regButton.click();
        //firstname
        _globalDriver.findElement(By.id("firstname")).sendKeys(generateUserName());
        //lastname
        _globalDriver.findElement(By.id("lastname")).sendKeys(generateUserName());
        //gim metai drop list
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div")).click();
        //drop list select
        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[2]")).click();
        //menuo drop list
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div")).click();
        ///drop list select
        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[4]")).click();
        ///diena drop list
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button")).click();
        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[3]")).click();
        String password = new String(generateUserName());
        _globalDriver.findElement(By.id("email")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.id("phone")).sendKeys("65482544");
        _globalDriver.findElement(By.id("password")).sendKeys(password);
        _globalDriver.findElement(By.id("password_repeat")).sendKeys(password);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click();
        ///html/body/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div[2]/button
        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
        WebElement adSubClose = _globalDriver.findElement(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon"));
        adSubClose.click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click();


    }

    @Test
    public void TestVyno5(){
        _globalDriver.get("https://vynoteka.lt/");

        WebElement ageVerifi = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerifi.click();

        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        _globalDriver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        //drop menu
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[1]/button")).click();

        //select from drop menu
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div[1]/div[1]/div/nav/div[1]/div/button")).click();

        //select sub category
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[2]/div[1]/div/nav/div[4]")).click();

        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/a")).click();
        // get item name and price
        String itemName = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[1]/h3")).getText();
        String itemPrice = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[1]/div/div")).getText();

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/button")).click();

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();

        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[2]/div/form/div[1]/div/input")).sendKeys("Belekoksbelekaitis@gmail.com");

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Belekaitis@23");

        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div/div[2]/div/form/div[4]/button")).click();






    }

    public static String generateUserName(){
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};
        Random random = new Random();
        StringBuilder username = new StringBuilder();
        int usernameLength = random.nextInt(10) + 10; // Random length between 5 to 14 cha
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alph
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            username.append(randomChar);
        }
        return username.toString();
    }
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder email = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers

            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            email.append(randomChar);
        }
        email.append("@");

        // Selecting random domain
        String randomDomain = domains[random.nextInt(domains.length)];
        email.append(randomDomain);

        return email.toString();
    }

}

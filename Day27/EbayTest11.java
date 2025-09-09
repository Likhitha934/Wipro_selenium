package testng_projectEbay;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.time.Duration; // Import Duration
import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait
import org.testng.annotations.AfterTest;

public class EbayTest11 {
    WebDriver driver;
    WebDriverWait wait; // Declare WebDriverWait object

    @BeforeTest
    
    public void beforeTest()  throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a timeout of 15 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
    }

   @Test(priority = 1)
    public void login() {
        WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
        signin.sendKeys(Keys.ENTER);
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        username.sendKeys("gnlikhitha67@gmail.com");
        username.sendKeys(Keys.ENTER);
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        password.sendKeys("Likhitha@21");
        password.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("ebay.com"));
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
       
    }

   @Test(priority = 2)
   public void changename() throws InterruptedException {
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"gh-my-ebay__link gh-rvi-menu\"]"))); 
       profile.click();

       WebElement acc = driver.findElement(By.linkText("Account"));
       acc.click();

       WebElement info = driver.findElement(By.cssSelector("a[id=\"account-settings-link-PI\"]"));
       info.click();

       WebElement edit = driver.findElement(By.cssSelector("button[id=\"individual_username_edit_button\"]"));
       edit.click();

       WebElement value = driver.findElement(By.cssSelector("input[name='username']"));
       value.clear();
       value.sendKeys("Likhitha31");
       value.sendKeys(Keys.ENTER);

       driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
 	  Thread.sleep(1000);
   }

   @Test(priority = 3)
   public void changeaddress() throws InterruptedException {
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"gh-my-ebay__link gh-rvi-menu\"]"))); 
       profile.click();

       WebElement acc = driver.findElement(By.linkText("Account"));
       acc.click();

       WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id=\"account-settings-link-ADDR\"]")));
       info.click();

       WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label=\"Edit Shipping address opens in new window or tab.\"]")));
       address.click();
       
       WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id=\"edit-address-SHIPPING\"]")));
       edit.click();

       WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=\"addressLine1-field\"]")));
       field.clear();
       field.sendKeys("Davangere");

       WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id=\"save-address-btn\"]")));
       submit.click();

       driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
 	  Thread.sleep(1000);
   }

    @Test
    public void search() {
        WebElement searchBox;
        ArrayList<String> products = new ArrayList<>();
        products.add("Watch");
        products.add("Laptop");
        products.add("Phone");

        for (String product : products) {
            searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
            searchBox.clear();
            searchBox.sendKeys(product);
            searchBox.sendKeys(Keys.ENTER);
          //  wait.until(ExpectedConditions.urlContains(product.toLowerCase()));
        }
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
    }

    @Test
    public void cart() {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchBox.sendKeys("Apple MacBook Pro 13 16GB RAM");
        searchBox.sendKeys(Keys.ENTER);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD")));
        String url = product.getAttribute("href");
        System.out.println(url);
        driver.get(url);
        WebElement cartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
        cartbtn.sendKeys(Keys.ENTER);
        WebElement seecart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("See in cart")));
        seecart.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
    }

    @Test
    public void remove() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class=\"gh-cart\"]>div[class=\"gh-flyout is-right-aligned gh-flyout--icon-target\"]")).click();
        Thread.sleep(2000);
        WebElement rmcart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test-id=\"cart-remove-item\"]")));
        rmcart.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
    }

   @Test
    public void category() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"gh-categories__title\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics"))).click();
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
    }

    @Test
    public void selectproduct() {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchBox.sendKeys("Apple MacBook Pro 13 16GB RAM");
        searchBox.sendKeys(Keys.ENTER);
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt=\" Apple MacBook Pro 13 RETINA INTEL CORE 16GB RAM 1TB SSD\"]")));
        Actions actions = new Actions(driver);
        actions.contextClick(img).perform();
    }

    @Test
    public void allcategories() throws InterruptedException {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchBox.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div[class=\"gh-header__logo-cats-wrap\"]")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.ebay.com/"));
        Thread.sleep(2000);
    }

    @Test
    public void language() throws InterruptedException {
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label=\"eBay Sites - United States - change site\"]")));
        Actions lang = new Actions(driver);
        lang.moveToElement(profile).perform();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("China"))).click();
        
    }

    @AfterTest
   public void afterTest() {
        if (driver != null) {
           // driver.quit();
        }
    }
}

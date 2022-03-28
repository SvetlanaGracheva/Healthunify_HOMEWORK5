package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Healthunify {
    public WebDriver driver;
    String weight;
    String heightCms;
    String height1;
    String height2;
    WebElement elementWeight;
    WebElement elementHeightCms;
    WebElement elementHeight1;
    WebElement elementHeight2;
    WebElement elementResult;


    @BeforeClass
    public void setupBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://healthunify.com/bmicalculator/");
        elementWeight = driver.findElement(By.xpath("//input[@name = 'wg']"));
        elementHeightCms = driver.findElement(By.xpath("//input[@name = 'ht']"));
        elementHeight1 = driver.findElement(By.xpath("//select[@name='opt2']"));
        elementHeight2 = driver.findElement(By.xpath("//select[@name='opt3']"));
        elementResult = driver.findElement(By.xpath("//input [@name='desc']"));
    }
    @Test
    public void checkCategoryObeseKgTest(){
        weight="20";
        height1="2";
        elementWeight.sendKeys(weight);
        elementHeight1.sendKeys(height1);
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String obeseWeight = elementResult.getAttribute("value");
        String obeseExpResul = "Your category is Obese";
        Assert.assertEquals( obeseWeight, obeseExpResul);
    }
    @Test
    public void checkCategoryStarvationKgTest (){
        weight= "11";
        height1="7";
        height2= "11";
        elementWeight.sendKeys(weight);
        elementHeight1.sendKeys(height1);
        elementHeight2.sendKeys(height2);
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String starvationWeight = elementResult.getAttribute("value");
        String starvationExpResul = "Your category is Starvation";
        Assert.assertEquals(starvationWeight,starvationExpResul);


    }

    @Test
    public void checkCategoryNormalKgTest() {
        weight = "50";
        heightCms = "160";
        elementWeight.sendKeys(weight);
        elementHeightCms.sendKeys(heightCms);
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String normalWeight = elementResult.getAttribute("value");
        String normalExpResul = "Your category is Normal";
        Assert.assertEquals(normalWeight,normalExpResul);

    }


    @AfterClass
    public void closeBrowser() {
        driver.quit();

    }


}
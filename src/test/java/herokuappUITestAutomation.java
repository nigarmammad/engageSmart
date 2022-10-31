import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class herokuappUITestAutomation {

/*

1. Create a public repo
2. Preferably use dotnet (any version) or any programming language of your choice, Selenium with local chrome driver, write a scenario that:
a. navigates The Internet (the-internet.herokuapp.com)
 b. adds n number of elements
 c. asserts that n number of elements exist on the page
 Bonus points if you can run it with GitHub actions and output a report.`
Let us know if you have any other questions before your HR phone screening interview. Please confirm you can attend

 */

    WebDriver driver;

    @BeforeClass
     void setupClass() {
        // to set up driver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        // to define the driver
        driver = new ChromeDriver();
        // navigates to the-internet.herokuapp.com
        driver.get("https://the-internet.herokuapp.com");
        // waits till 5 seconds each element if the element not found in DOM
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // to maximize window
        driver.manage().window().maximize();
    }

    @Test
    public void testAdd_N_Number_Off_Elements(){

        // click Add/Remove Elements link
        driver.findElement(By.linkText("Add/Remove Elements")).click();

      //Verify whether Add Element button is displayed  .
        boolean addElement = driver.findElement(By.xpath("//*[text()='Add Element']")).isDisplayed();
        if (addElement) {
            Assert.assertTrue(addElement, "Add Element button is displayed");

        }
        else{
            Assert.assertTrue(addElement,"Add Element button is not displayed");

        }

         //Verify whether Add Element button is clickable
           addElement = driver.findElement(By.xpath("//*[text()='Add Element']")).isEnabled();
           Assert.assertTrue(addElement, "Add Element is enabled to click");

        WebElement addElementButton= driver.findElement(By.xpath("//*[text()='Add Element']"));
        int n= ThreadLocalRandom.current().nextInt(10, 100);
        for (int i=0;i<n;i++){
            addElementButton.click();
        }

        //Verify  that n number of elements exist on the page
        List<WebElement> elements=driver.findElements(By.xpath("//*[@class='added-manually']"));
        int elementsCount = elements.size();
        Assert.assertNotNull(elementsCount, "Number of elements exist on the page is "+elementsCount);
        Assert.assertEquals(n,elementsCount);
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }
}


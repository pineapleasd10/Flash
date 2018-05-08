package net.ukr.pineappleasd10;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    //WebDriver driver = new ChromeDriver();
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/Install/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");
    }

    @AfterClass
    public static void tearDown() {
        try {

            WebElement menuUser = driver.findElement(By.xpath("//*[@id=\"content\"]/header/div[1]/div[2]/a"));
            menuUser.click();
            System.out.println("Menu is found ");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Menu not found " + e.getMessage());
            Assert.fail();
            return;
        }

        try {
            WebElement logoutButton = driver.findElement(By.id("login__logout"));
            logoutButton.click();
            System.out.println("Logout success ");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Logout failed " + e.getMessage());
            Assert.fail();
            return;
        }

        try {
            driver.quit();
        } catch (Error e) {
            System.out.println("Cannot close browser ");
            Assert.fail();

        }
    }

    @Test
    public void userLogin() {
        try {
            WebElement loginField = driver.findElement(By.id("88id-1"));
            System.out.println("Login field found ");
            loginField.sendKeys("pineappleasd10");
            System.out.println("Login set ");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Login field NOT found " + e.getMessage());
            Assert.fail();
            return;
        }


        try {
            WebElement passwordField = driver.findElement(By.id("id-2"));
            System.out.println("Password field found ");
            passwordField.sendKeys("Roman1994");
            System.out.println("Password set");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Password field NOT found " + e.getMessage());
            Assert.fail();
            return;
        }


        try {

            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/main/form/button/div"));
            System.out.println("Login button found ");
            loginButton.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Login button NOT found " + e.getMessage());
            Assert.fail();
            return;
        }


        try {
            WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
            String mailUser = profileUser.getText();
            Assert.assertEquals("pineappleasd10@ukr.net", mailUser);
            System.out.println("Login success ");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Login Failed " + e.getMessage());
            Assert.fail();

        }
    }
}



class Tedst{
    public static void main(String[] args) {
        System.out.println("Test");
    }

}
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChatBotTest {
    public static void main(String[]args) {
        // to call the chromedriver
        try {
            WebDriverManager.chromedriver().setup();
            //create the webdriver instance
            WebDriver driver=new ChromeDriver();
            //to maximize the webdriver window
            driver.manage().window().maximize();
            //to open the url
            driver.get("https://qachatbot.ccbp.tech/");
            //to get the currentUrl
            String currentUrl=driver.getCurrentUrl();
            //expected Url
            String expectedUrl="https://qachatbot.ccbp.tech/";

            //to check the condition
            if (currentUrl.equals(expectedUrl)){
                System.out.println("both url to be matched");
                // to enter the input
                WebElement InputField=driver.findElement(By.xpath("/html/body/div/div[3]/input"));
                InputField.sendKeys("Hi");
                //to click the button
                WebElement clickButton=driver.findElement(By.xpath("/html/body/div/div[3]/button"));
                clickButton.click();
                //enter the good morning message
                WebElement goodMorningMsg=driver.findElement(By.xpath("/html/body/div/div[3]/input"));
                InputField.sendKeys("Good Morning");
                //to click the button
                clickButton.click();
                // enter the input as help
                InputField.sendKeys("Help!!!");
                //to click the button
                clickButton.click();
                // Find the <div> element with id="chatContainer"
                WebElement chatContainer = driver.findElement(By.id("chatContainer"));

                // Find all <span> elements within the chat container using descendant axis
                List<WebElement> messages = chatContainer.findElements(By.xpath(".//span"));
                //print the one by one
                for (WebElement message : messages) {
                    System.out.println("Message: " + message.getText());
                }





            }else{
                System.out.println("both url to be unmatched");
            }
            driver.close();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

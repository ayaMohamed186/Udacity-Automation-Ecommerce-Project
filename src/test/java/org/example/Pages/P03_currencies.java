package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_currencies {
    public P03_currencies(){
        PageFactory.initElements(Hooks.driver,this);
    }


    @FindBy(id = "customerCurrency")
    public WebElement euroSymbolEle;

    public List<WebElement> getPricesOfAllProduct(){
        List<WebElement> pricesInHomePage = Hooks.driver.findElements(By.xpath("//span[@class =\"price actual-price\"]"));
        return pricesInHomePage;
    }


}

package org.example.StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_currencies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_currencies currencyPageObj = new P03_currencies();


    @When("user select euro option")
    public void selectEuroCurrency(){
        WebElement currencyList =  currencyPageObj.euroSymbolEle;
        Select select = new Select(currencyList);
        select.selectByIndex(1);
    }

    @Then("euro symbol is displayed in all product on home page")
    public void euroSymbolIsDisplayed(){

        for(int i = 0 ; i<4 ; i++)
        {
           List<WebElement> pricesInHomePage =  currencyPageObj.getPricesOfAllProduct();
           String actualCurrencyDisplayed = pricesInHomePage.get(i).getText();
           System.out.println("currency is " + actualCurrencyDisplayed);
           Assert.assertTrue(actualCurrencyDisplayed.contains("€"));
           boolean assertResult = actualCurrencyDisplayed.contains("€");
            System.out.println("result of assert should be true = "+ assertResult );
        }
    }
}

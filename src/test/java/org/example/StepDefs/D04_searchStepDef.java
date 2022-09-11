package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class D04_searchStepDef {
    P04_HomePage homePageOgj = new P04_HomePage();
    SoftAssert soft = new SoftAssert();

    @When("user search on product {string}")
    public void enterDataToSearch(String productName){
        homePageOgj.searchTxtEle.sendKeys(productName);
    }

    @And("press on search button")
    public void pressOnSearchBtn(){
        homePageOgj.searchBtnEle.click();
    }

    @Then("search results contains {string}")
    public void searchResultDisplayedSucc(String ProductName){
        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/search?q=book";
        soft.assertEquals(actualURL , expectedURL);


        List<WebElement> count =    homePageOgj.searchResult();
        int resultCount = count.size();
        System.out.println("result count equal = " + resultCount);

        for(int i = 0 ; i<resultCount ; i++)
        {
            String actualResultProductName = count.get(i).getText();
            soft.assertTrue(actualResultProductName.toLowerCase(Locale.ROOT).contains(ProductName.toLowerCase()));
            Boolean result = actualResultProductName.toLowerCase(Locale.ROOT).contains(ProductName.toLowerCase()) ;
            System.out.println("result of search should be true = " + result );

        }

    }

    @And("press on product in search result")
    public void pressOnFirstSearchResult(){
        homePageOgj.serachResultIconEle.click();
    }

    @Then("search results contains {string} using sku")
    public void verifySearchResultHaveSKU(String skutName){
        String actualSku = homePageOgj.getActualSkuInResult();
        System.out.println("actual sku displayed = " + actualSku);
        String expectedSku =  skutName ;

        Assert.assertTrue(actualSku.contains(expectedSku));
        System.out.println("actual sky " + actualSku + " equal sku send in search "+ expectedSku + " = " + actualSku.contains(expectedSku));
    }
}

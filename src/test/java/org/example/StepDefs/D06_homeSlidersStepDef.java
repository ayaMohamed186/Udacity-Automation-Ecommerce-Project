package org.example.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {

    P04_HomePage homePageObj = new P04_HomePage();


    @Given("click on first slide nokia")
    public void clickOnFirstSlideOnHomePage(){
       // homePageObj.sliders().get(0).click();
        homePageObj.firstSliderEle.click();
    }

    @Then("click on first slide should be navigate to nokia url")
    public void clickOnFirtSliderRedirect(){
        String actualURLdisplayed = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(actualURLdisplayed , expectedURL);
    }

    @Given("click on second slide iphone")
    public void clickOnSecondSlideOnHomePage(){
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePageObj.secondSliderEle.click();

       // homePageObj.sliders().get(1).click();

       /* WebDriverWait waitUntil = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        WebElement secondSlide = homePageObj.sliders().get(1);
        waitUntil.until(ExpectedConditions.attributeToBe(secondSlide,"style","display: none"));
        homePageObj.sliders().get(1).click();*/

       // Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //homePageObj.sliders().get(1).click();
    }

    @Then("click on second slide should be navigate to iphone url")
    public void clickOnSecondSliderRedirect(){
        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(actualURL,expectedUrl);
    }

}

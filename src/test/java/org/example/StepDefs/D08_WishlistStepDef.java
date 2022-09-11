package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P04_HomePage homePageObj = new P04_HomePage();

    @Given("user press on wishlist Button")
    public void pressOnWhishlistForProduct(){
        homePageObj.whishlistBtn.click();
    }

    @Then("success message is displayed for user")
    public void verifySuccessMsgDisplayed(){
        String actualSuccessMsg = homePageObj.successMsgEle.getText();
        System.out.println("actual success msg displayed is = "+ actualSuccessMsg);

        String expectedSuccessMsg = "The product has been added to your wishlist";
        System.out.println("expected msg is = " + expectedSuccessMsg);
        Assert.assertTrue(actualSuccessMsg.contains(expectedSuccessMsg));

       String actualMsgColor = homePageObj.msgBackground.getCssValue("background-color");
       String actualColorDisplayedInHex  = Color.fromString(actualMsgColor).asHex();
       System.out.println("actual msg color display is = " + actualColorDisplayedInHex);

        String expectedMsgColor = "#4bb07a";
        System.out.println("expected msg color is = " + expectedMsgColor);

        Assert.assertEquals(actualColorDisplayedInHex , expectedMsgColor);
    }

    @And("User open wishlist page & verify that number is increased")
    public void verifyThatWashlistValueIncrease() throws InterruptedException {
        //wait until msg disappear
        WebDriverWait w = new WebDriverWait(Hooks.driver , Duration.ofSeconds(4));
        w.until(ExpectedConditions.invisibilityOf(homePageObj.successMsgEle));

        homePageObj.wishlistLabelInMenu.click();
        String qty = homePageObj.wishlistQTY.getAttribute("value");
        System.out.println("quantitiy equal " + qty);

        Assert.assertTrue(Integer.parseInt(qty) >0);
        System.out.println("status is " + (Integer.parseInt(qty)>0) );

    }
}

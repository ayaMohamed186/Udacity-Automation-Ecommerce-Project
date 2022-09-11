package org.example.StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.Pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_registerStepDef {

    // Object from register Page
    P01_register registerPgeObj = new P01_register();
    SoftAssert soft = new SoftAssert();


    @Given("user go to register page")
    public void goRegisterPage()
    {
        registerPgeObj.goToRgisterPage().click();
    }

    @When("user select gender type")
    public void selectGenderType(){
        registerPgeObj.genderType.click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enterFirstAndLastName(){
        registerPgeObj.firstNameEle.sendKeys("Automation");
        registerPgeObj.lastNameEle.sendKeys("tester");
    }

    @And("user enter date of birth")
    public void enterDateOfBirth(){
        Select day = new Select(registerPgeObj.dayEle);
        day.selectByIndex(17);

        Select month = new Select(registerPgeObj.monthEle);
        month.selectByIndex(5);

        Select year = new Select(registerPgeObj.yearEle);
        year.selectByValue("1997");
    }

    @And("user enter email")
    public void enterEmail() throws IOException {
        registerPgeObj.emailEle.sendKeys("ayamahamed951@gmail.com");
    }

    @And("user fills Password fields")
    public void enterPassword(){

        registerPgeObj.passwordEle.sendKeys("password1");
        registerPgeObj.confirmPassEle.sendKeys("password1");
    }

    @And("user clicks on register button")
    public void clickOnRegisterBtn()
    {
        registerPgeObj.registerSubmitBtn.click();
    }


    @Then("success message is displayed")
    public void assertSuccessRegister() throws InterruptedException {

        String actualSuccessMsg = registerPgeObj.successMsg.getText();
        String expectedSuccessMsg = "Your registration completed";
        soft.assertEquals(actualSuccessMsg , expectedSuccessMsg);

        String actualSuccessMsgColor = registerPgeObj.successMsg.getCssValue("color");
        String expectedSuccessMsgColor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actualSuccessMsgColor,expectedSuccessMsgColor);

        soft.assertAll();
        Thread.sleep(2000);

    }

    @And("logout")
    public void logout(){
        registerPgeObj.logoutBtn.click();
    }





}

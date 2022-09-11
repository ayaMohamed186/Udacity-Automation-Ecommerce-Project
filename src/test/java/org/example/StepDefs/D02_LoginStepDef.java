package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_LoginPage;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D02_LoginStepDef {

    P02_LoginPage loginPageObj = new P02_LoginPage();
    SoftAssert soft = new SoftAssert();


    @Given("user go to login page")
    public void redirectToLoginPage(){
        loginPageObj.loginBtn.click();
    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void enterValidData(String email , String password) throws IOException {
        loginPageObj.emailEle.clear();
        loginPageObj.emailEle.sendKeys(email);
        loginPageObj.passwordEle.sendKeys(password);
       }

    @And("user press on login button")
    public void pressOnloginSubmitBtn() throws InterruptedException {
        loginPageObj.loginSubmitBtn.click();
        Thread.sleep(3000);
    }

    @Then("user login to the system successfully")
    public void loginSuccessfully(){
        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/";

        soft.assertEquals(actualURL, expectedURL);
        soft.assertTrue(loginPageObj.myAccBtn.getText().contains("My account"));

        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void wrongLogin(){
        String actualErrorMsg = loginPageObj.errorMsgInLogin.getText();
        String ExpectedErrorMsg = "Login was unsuccessful";

        String actualColor = loginPageObj.errorMsgInLogin.getCssValue("color");
        System.out.println(actualColor);
        String expectedColor = "(rgba(228, 67, 75, 1)";

        soft.assertEquals(actualColor, expectedColor);
        soft.assertTrue(actualErrorMsg.contains(ExpectedErrorMsg));

    }
}

package org.example.Pages;

import io.cucumber.java.en.And;
import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {

    public P01_register(){
        PageFactory.initElements(Hooks.driver,this);
    }
    public WebElement goToRgisterPage(){
        WebElement registerBtn = Hooks.driver.findElement(By.className("ico-register"));
        return registerBtn;
    }

    @FindBy(id="gender-female")
    public WebElement genderType;

    @FindBy(id = "FirstName")
    public WebElement firstNameEle;

    @FindBy(id = "LastName")
    public WebElement lastNameEle;

    @FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]")
    public WebElement dayEle;

    @FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]")
    public WebElement monthEle;

    @FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]")
    public WebElement yearEle;

    @FindBy(id = "Email")
    public WebElement emailEle;

    @FindBy(id = "Password")
    public WebElement passwordEle;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassEle;

    @FindBy(id = "register-button")
    public WebElement registerSubmitBtn;

    @FindBy(xpath = "//div[@class=\"result\"]")
    public WebElement successMsg;

    @FindBy(xpath = "//a[@class=\"ico-logout\"]")
    public WebElement logoutBtn;


}

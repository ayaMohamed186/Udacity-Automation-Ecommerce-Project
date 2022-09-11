package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_LoginPage {
    public P02_LoginPage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(className = "ico-login")
    public WebElement loginBtn;

    @FindBy(id = "Email")
    public WebElement emailEle;

    @FindBy(id = "Password")
    public WebElement passwordEle;

    @FindBy(className = "login-button")
    public WebElement loginSubmitBtn;

    @FindBy(xpath = "//a[@class=\"ico-account\"]")
    public WebElement myAccBtn;

    @FindBy(className = "message-error")
    public WebElement errorMsgInLogin;



}

package org.example.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P04_HomePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    P04_HomePage homePageObj = new P04_HomePage();

    @Given("user opens facebook link")
    public void openFaceLink() throws InterruptedException {
        homePageObj.facebookEle.click();
        Thread.sleep(2000);
    }
    @Then("verify that correct facebook link is opened in new tab")
    public void verifyFacePageOpen(){
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        String urlOfTab0 = Hooks.driver.getCurrentUrl();
        System.out.println("URL of first main tab = "+ urlOfTab0);

        Hooks.driver.switchTo().window(tabs.get(1));
        String urlOfOpenedTab = Hooks.driver.getCurrentUrl();
        System.out.println("URL of new tab opened = "+ urlOfOpenedTab);

       String expectedURL = "https://www.facebook.com/nopCommerce";
       Assert.assertEquals(urlOfOpenedTab , expectedURL);
       //Assert.assertTrue(urlOfOpenedTab.contains("facebook"));

        Hooks.driver.close();
    }

    @Given("user opens twitter link")
    public void openTwitterLink(){
        homePageObj.twitterEle.click();
    }
    @Then("verify that correct twiiter link is opened in new tab")
    public void verifyTwitterPageOpen(){
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        String urlOfTab0 = Hooks.driver.getCurrentUrl();
        System.out.println("URL of first main tab = "+ urlOfTab0);

        Hooks.driver.switchTo().window(tabs.get(1));
        String urlOfOpenedTab = Hooks.driver.getCurrentUrl();
        System.out.println("URL of new tab opened = "+ urlOfOpenedTab);

        String expectedURL = "https://twitter.com/nopCommerce";
        Assert.assertEquals(urlOfOpenedTab , expectedURL);
        Hooks.driver.close();
    }

    @Given("user opens rss link")
    public void openRssLink(){
        homePageObj.rssEle.click();
    }
    @Then("verify that correct rss link is opened in new tab")
    public void verifyRssPageOpen(){
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        String urlOfTab0 = Hooks.driver.getCurrentUrl();
        System.out.println("URL of first main tab = "+ urlOfTab0);

        Hooks.driver.switchTo().window(tabs.get(1));
        String urlOfOpenedTab = Hooks.driver.getCurrentUrl();
        System.out.println("URL of new tab opened = "+ urlOfOpenedTab);

        String expectedURL = "https://demo.nopcommerce.com/new-online-store-is-open";
        Assert.assertEquals(urlOfOpenedTab , expectedURL);
        Hooks.driver.quit();
    }

    @Given("user opens youtube link")
    public void openYoutubeLink(){
        homePageObj.youtubeEle.click();
    }
    @Then("verify that correct youtube link is opened in new tab")
    public void verifyYoutubePageOpen(){
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        String urlOfTab0 = Hooks.driver.getCurrentUrl();
        System.out.println("URL of first main tab = "+ urlOfTab0);

        Hooks.driver.switchTo().window(tabs.get(1));
        String urlOfOpenedTab = Hooks.driver.getCurrentUrl();
        System.out.println("URL of new tab opened = "+ urlOfOpenedTab);

        String expectedURL = "https://www.youtube.com/user/nopCommerce";
        Assert.assertEquals(urlOfOpenedTab , expectedURL);
        Hooks.driver.close();
    }




}

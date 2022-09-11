package org.example.StepDefs;


import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class D05_hoverCategoriesStepDe {
    P04_HomePage homePageObj = new P04_HomePage();

    @When("hover on random category & select sub category")
    public void hoverOnRandomCategories() throws InterruptedException {
        // hover on one from 3 main category
        int randomCategoryNumber = new Random().nextInt(3); // to be in the first 3 categories which have sub categories
        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(homePageObj.categories().get(randomCategoryNumber)).perform();

        // get text of selected main category
        String selectedMainCategory = homePageObj.categories().get(randomCategoryNumber).getText();
        System.out.println("Main category selected is = " + selectedMainCategory);

        // list sub category in these main category
        List<WebElement> subCategories = homePageObj.subCategories(randomCategoryNumber);
        int randomSubCategoryNumber = new Random().nextInt(3);

        // click on sub category
        Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String selectedSubCategory = subCategories.get(randomSubCategoryNumber).getText().toLowerCase().trim();
        Thread.sleep(1500);
        subCategories.get(randomSubCategoryNumber).click();
        System.out.println("sub category selected is = " + selectedSubCategory);

        // get text of actual sub category displayed as a title
        String actualPageTitle = homePageObj.subCategoryPageTitle.getText().toLowerCase().trim();
        System.out.println("actual page title for selected sub category = " + actualPageTitle);

        // get text of sub category chosen
        System.out.println("selected sub category " +" =" +selectedSubCategory + " is equal to actual sub category displayed " + " =" +actualPageTitle);

        Assert.assertTrue(actualPageTitle.contains( selectedSubCategory) );

    }

  /*  @Then("assert page title equal selected sub category")
    public void selectSubCategoryForSelectuedMain() throws InterruptedException {


    }*/
}

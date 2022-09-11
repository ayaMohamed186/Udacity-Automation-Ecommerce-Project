package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Base64;
import java.util.List;

public class P04_HomePage {

    public P04_HomePage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    // for feature4 search
    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement searchTxtEle;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement searchBtnEle;

    public List<WebElement> searchResult(){
        List<WebElement> countOfSearchResult = Hooks.driver.findElements(By.xpath("//div[@class=\"item-box\"]"));
        return countOfSearchResult;
    }

    @FindBy(className = "picture")
    public WebElement serachResultIconEle;

    public String getActualSkuInResult(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"sku\"]")).getText();
    }

    // for feature5 hover on category
    public List<WebElement> categories(){
        List<WebElement> homePageCatecories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
        return homePageCatecories;
    }

    @FindBy(className = "current-item")
    public WebElement subCategoryPageTitle;

    public List<WebElement> subCategories(int categoryNum){

        categoryNum = categoryNum+1;
        List<WebElement> subCategoriesA = Hooks.driver.findElements((By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+ categoryNum + "]/ul[@class=\"sublist first-level\"]/li"))) ;
        return subCategoriesA;
    }

    // for feature6 home slider
    @FindBy(xpath ="(//a[@class='nivo-imageLink'])[1]")
    public WebElement firstSliderEle;

    @FindBy(xpath = "(//a[@class='nivo-imageLink'])[2]")
    public WebElement secondSliderEle;

     /*
    public List<WebElement> sliders(){
        List<WebElement> slidersEle = Hooks.driver.findElements(By.id("nivo-slider"));
        return slidersEle;
    } */

    // for feature7 follow us
    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebookEle;

    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitterEle;

    @FindBy(css = " a[href=\"/news/rss/1\"]")
    public WebElement rssEle;

    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtubeEle;

    // for feature8 wishlist
    @FindBy(xpath = "(//button[@title='Add to wishlist'])[3]")
    public WebElement whishlistBtn;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement successMsgEle;

    @FindBy(xpath = "//div[@class = \"bar-notification success\"]")
    public WebElement msgBackground;

    @FindBy(className = "wishlist-label")
    public WebElement wishlistLabelInMenu;


    @FindBy(xpath = "//input[@value='1']")
    public WebElement wishlistQTY;



}

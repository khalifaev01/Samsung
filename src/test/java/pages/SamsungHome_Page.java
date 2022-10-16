package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class SamsungHome_Page {

    public SamsungHome_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//ul/li[@class=\"gnb__search\"]")
    public WebElement searchBtn;

    @FindBy( xpath = "//*[@id='gnb-search-keyword']")
    public WebElement searchBox;


    @FindBy(xpath = "//div/div[contains(text(),\"Item Type\")]")
    public WebElement itemType;

    @FindBy(xpath = "//div/span/span[contains(text(), \"Mobile Accessories\")]")
    public WebElement mobileAccessories;

    @FindBy( xpath = "(//div/a[contains(text(),\"BUY NOW\")])[30]")
    public WebElement buyNowBtn;

    @FindBy(xpath = "//div[@class='star-rating']/div[@class=\"dv-star-rating\"]")
    public WebElement reviewAVGRate;


    @FindBy(id = "reviewComments")
    public WebElement reviewComment;


public WebElement getSortByDropDown() {

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

    WebElement sortByDropD = (WebElement) javascriptExecutor.executeScript("return document.querySelector('#reviewComments')." +
            "shadowRoot.querySelector('#bv-dropdown-select-reviews')");

    return sortByDropD;
}


    public WebElement getHighestToLowestRate(){

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebElement highToLowRate = (WebElement) js.executeScript("return document.querySelector('#reviewComments')." +
            "shadowRoot.querySelector('#bv-dropdown-title-reviews > div')");

    return highToLowRate;
    }

}

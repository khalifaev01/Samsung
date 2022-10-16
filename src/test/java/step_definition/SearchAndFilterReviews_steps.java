package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SamsungHome_Page;
import utilities.Driver;



public class SearchAndFilterReviews_steps {

    SamsungHome_Page homePage = new SamsungHome_Page();
    Actions actions = new Actions(Driver.getDriver());


    @Given("user navigates to homepage")
    public void user_navigates_to_homepage() {
        Driver.getDriver().get("https://www.samsung.com");
    }

    @Given("user searches for an {string}")
    public void user_searches_for_an(String item) {
        homePage.searchBtn.click();
        homePage.searchBox.sendKeys("galaxy z flip 4", Keys.ENTER);
    }

    @Given("user selects mobile accessories from left filter tab")
    public void user_selects_mobile_accessories_from_left_filter_tab() {
        homePage.itemType.click();
        homePage.mobileAccessories.click();
    }

    @Given("user scrolls down to the page and selects one of the last three items")
    public void user_scrolls_down_to_the_page_and_selects_one_of_the_last_three_items() {
       actions.sendKeys(homePage.buyNowBtn, Keys.PAGE_DOWN).click().build().perform();
    }

    @Given("user navigates to the review page by selecting the review button")
    public void user_navigates_to_the_review_page_by_selecting_the_review_button() {
        actions.moveToElement(homePage.reviewAVGRate);
        homePage.reviewAVGRate.click();
    }

    @Given("user filters the review rates by descending order")
    public void user_filters_the_review_rates_by_descending_order() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.reviewComment));
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.moveToElement(homePage.getSortByDropDown());
        homePage.getHighestToLowestRate().click();

    }

    @Then("user should be able to see highest review rate in the first order")
    public void user_should_be_able_to_see_highest_review_rate_in_the_first_order() {

    }


}

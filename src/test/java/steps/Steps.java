package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class Steps {


    @Given("I navigate to Nielsen Sports web app")
    public void i_navigate_to_Nielsen_Sports_web_app() {
        Driver.getDriver().get("URL"); // URL is a placeholder for the real app's URL


    }

    @When("I enter correct {string} and {string}")
    public void i_enter_correct_and(String name, String password) {
        Driver.getDriver().findElement(By.id("login")).sendKeys(name); //Assume all the elements have unique IDs
        Driver.getDriver().findElement(By.id("pwd")).sendKeys(password);
        Driver.getDriver().findElement(By.id("btn"));
    }

    @Then("I am able to successfully log in to the system")
    public void i_am_able_to_successfully_log_in_to_the_system() {
        String message = Driver.getDriver().findElement(By.id("welcome")).getText(); //Assume user should see a welcome message
        Assert.assertEquals(message,"Welcome, user!");
    }

    @When("I enter wrong {string} and {string}")
    public void i_enter_wrong_and(String name, String password) {
        Driver.getDriver().findElement(By.id("login")).sendKeys(name);
        Driver.getDriver().findElement(By.id("pwd")).sendKeys(password);
        Driver.getDriver().findElement(By.id("btn"));
    }

    @Then("I get a warning message")
    public void i_get_a_warning_message() { //Assume user should see a warning message
        String popUp = Driver.getDriver().findElement(By.id("warning")).getText();
        Assert.assertEquals(popUp,"You entered wrong username/password");
    }

    @Then("I see {int} columns with images on the page") //Assume images are stored in a table on the 1st row
    public void i_see_columns_with_images_on_the_page(Integer num) {
      List<WebElement> list = Driver.getDriver().findElements(By.xpath("//table[@id='tableName']/tbody/tr[1]/td)"));
      Assert.assertTrue(list.size()==3);
      for (int i =0; i<3;i++){
          Assert.assertTrue(list.get(i).getTagName().equals("img"));
      }
    }

    @Then("each image has a proper {string}")
    public void each_image_has_a_proper(String tag) { //Assume all other tags are stored on rows number 2, 3 and 4
        Driver.getDriver().findElements(By.id("additional_info"));
        for (int i = 2; i < 5; i++) {
            List<WebElement> list = Driver.getDriver().findElements(By.xpath("//table[@id='tableName']/tbody/tr/td[i])"));
            for (int j = 0; j < 3; j++) {
                Assert.assertTrue(list.get(i).getText().contains(tag));
            }
        }
    }
}

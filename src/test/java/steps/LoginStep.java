package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {
    private WebDriver driver = null;

    @Given("^user navigates to login page$")
    public void navigateToLoginPage() throws Throwable{
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("^user enters invalid \"([^\"]*)\" and/or \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String username, String password) throws Throwable {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^user clicks login button$")
    public void userClickLoginButton() throws Throwable{
        driver.findElement(By.className("radius")).click();
    }

    @Then("^login should be unsuccessful$")
    public void validateSuccessfulLogin() throws Throwable{
        if(driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/login")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();
    }
}

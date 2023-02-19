package org.stepdefinition;

import org.base.Baseclass;
import org.fbpojo.FBloginPOJO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Fblogin extends Baseclass {
	FBloginPOJO f;
	@Given("to launch the chrome browser and maximise")
	public void to_launch_the_chrome_browser_and_maximise() {
	    launchBrowser();
	    WindowMaximize();
	}

	@When("to launch fb url")
	public void to_launch_fb_url() {
	   launchUrl("https://en-gb.facebook.com/");
	}

	@When("to pass username in email field")
	public void to_pass_username_in_email_field() {
	 f = new FBloginPOJO();
	 passTest("selenium@gmail.com",f.getVarRef());
	}

	@When("to pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
	    f = new FBloginPOJO();
	    passTest("123456",f.getPassword());
	}

	@When("to click the login button")
	public void to_click_the_login_button() {
	    f = new FBloginPOJO();
	    Clickbutton(f.getLoginbtn());
	}

	@When("ckeck whether navigate to homepage or not")
	public void ckeck_whether_navigate_to_homepage_or_not() {
	    System.out.println("ckeck whether navigate to homepage or not");
	}

	@Then("to close the browser")
	public void to_close_the_browser() {
	   closeEntireBrowser();
	}
}

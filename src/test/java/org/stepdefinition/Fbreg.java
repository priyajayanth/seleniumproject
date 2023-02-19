package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.Baseclass;
import org.fbpojo.FBloginPOJO;
import org.fbpojo.Signinpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Fbreg extends Baseclass {
	Signinpojo s;
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
	    launchBrowser();
	    WindowMaximize();
	}

	@When("To launch the url of the facebook application")
	public void to_launch_the_url_of_the_facebook_application() throws InterruptedException {
	  launchUrl("https://en-gb.facebook.com/"); 
	  Thread.sleep(3000);
	}

	@When("To click create new account button")
	public void to_click_create_new_account_button() throws InterruptedException {
	    s = new Signinpojo();
	    Clickbutton(s.getCreatenewaccount());
	    Thread.sleep(3000);
	}

	@When("To pass firstname in firstname box")
	public void to_pass_firstname_in_firstname_box(DataTable d) throws InterruptedException {
		Thread.sleep(3000);
		List<String> l = d.asList();
		 s = new Signinpojo();
		 passTest(l.get(2), s.getFirstnamebox());
		 Thread.sleep(3000);
	}

	@When("To pass secondname in secondname box")
	public void to_pass_secondname_in_secondname_box(DataTable d) {
		  Map<String, String> m = d.asMap(String.class, String.class);
		 s = new Signinpojo();
		 passTest( m.get("secondname3"),s.getSecondnamebox());
	}

	@When("to pass email or mobile no in emailbox")
	public void to_pass_email_or_mobile_no_in_emailbox(DataTable d) {
		List<List<String>> l = d.asLists();
		 s = new Signinpojo();
		 passTest(l.get(2).get(2),s.getEmailormobilbox());
	}

	@When("to create new password")
	public void to_create_new_password(DataTable d) {
		List<List<String>> m = d.asLists();
		 s = new Signinpojo();
		 passTest(m.get(1).get(2),s.getPasswordbox());
	}

	@Then("to close browser")
	public void to_close_browser() {
	    closeEntireBrowser();
	}
	
}

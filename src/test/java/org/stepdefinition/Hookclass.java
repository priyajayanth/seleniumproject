package org.stepdefinition;

import org.base.Baseclass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookclass extends Baseclass{
	@Before(order=1)
private void precondition1() {
	launchBrowser();
	System.out.println("launch browser");
	}
	@Before(order=2)
	private void precondition2(){
		WindowMaximize();
		System.out.println("");
	}
	@Before(order=3)
	private void precondition3(){
		launchUrl("https://en-gb.facebook.com/");
		System.out.println("launchurl");
	}
	@After(order=4)
	private void postcondition() {
		closeEntireBrowser();
		System.out.println("closebrowser");

	}
}
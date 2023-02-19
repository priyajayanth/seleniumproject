package org.fbpojo;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinpojo extends Baseclass{
public Signinpojo() {
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[text()='Create new account']")
private WebElement createnewaccount;

public WebElement getCreatenewaccount() {
	return createnewaccount;
}

public WebElement getFirstnamebox() {
	return firstnamebox;
}

public WebElement getSecondnamebox() {
	return secondnamebox;
}

public WebElement getEmailormobilbox() {
	return emailormobilbox;
}

public WebElement getPasswordbox() {
	return passwordbox;
}
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement firstnamebox;

@FindBy(xpath="(//input[@type='text'])[3]")
private WebElement secondnamebox;

@FindBy(xpath="(//input[@type='text'])[4]")
private WebElement emailormobilbox;

@FindBy(name="reg_passwd__")
private WebElement passwordbox;
}

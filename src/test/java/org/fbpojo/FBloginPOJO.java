package org.fbpojo;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBloginPOJO extends Baseclass {
public FBloginPOJO() {
PageFactory.initElements(driver, this);
}
@FindAll({
@FindBy(xpath="//input[@id='email']"),
@FindBy(xpath="//input[@name='pass']"),
@FindBy(xpath="//input[@data-testid='royal_email']")
})
private WebElement varRef;
 
@FindBy(name="pass")
private WebElement password;

@FindBy(name="login")
private WebElement loginbtn;

public WebElement getVarRef() {
	return varRef;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLoginbtn() {
	return loginbtn;
}



}


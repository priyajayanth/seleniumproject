package org.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
glue = "org.stepdefinition",
monochrome = true, 
strict = true ,
snippets = SnippetType.CAMELCASE,
tags = "@Sanity"
)
public class testrunnerclass {

}

package com.discover.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
 
@CucumberOptions(plugin ={"pretty",
"html:build/reports/cucumber-reports/cucumber-reports.html","json:build/reports/cucumber-reports/acceptance-test-results.json"},
                 features= {"src/test/resources/features/Passenger.feature"}, 
                 glue= {"com.discover.cucumber.stepdefinitions"})
 
public class CucumberRunnerTest {

}
 

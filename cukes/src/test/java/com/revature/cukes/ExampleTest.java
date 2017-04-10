package com.revature.cukes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleTest {

	@Given("^I have a precondition$")
	public void i_have_a_precondition() throws Throwable {
		System.out.println("BACKGROUND");
	}

	@When("^I take this action$")
	public void i_take_this_action() throws Throwable {
		System.out.println("WHEN SCENARIO");
	}

	@Then("^I get this result$")
	public void i_get_this_result() throws Throwable {
		System.out.println("THEN SCENARIO");
	}

	@Given("^I have an example \"([^\"]*)\"$")
	public void i_have_an_example(String arg1) throws Throwable {
		System.out.println("GIVEN " + arg1 + " OUTLINE");
	}

	@When("^I act on it$")
	public void i_act_on_it() throws Throwable {
		System.out.println("WHEN OUTLINE");
	}

	@Then("^this \"([^\"]*)\" occurs$")
	public void this_occurs(String arg1) throws Throwable {
		System.out.println("THEN " + arg1 + " OUTLINE");
	}
}

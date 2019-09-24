package com.ge.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ge.exercise1.ParserTest;
import com.ge.exercise3.AccountTest;
import com.ge.exercise3.BankTest;
import com.ge.exercise4.GE90Test;
import com.ge.exercise4.GE9xTest;
import com.ge.exercise4.GENxTest;
import com.ge.exercise4.GEPassportTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	//For Exercise 1
	ParserTest.class,
//	For Exercise 2
	AccountTest.class,
	BankTest.class,
//	For Exercise 4	
	GE90Test.class,
	GE9xTest.class,
	GENxTest.class,
	GEPassportTest.class
	})
public class TestSuite {

}

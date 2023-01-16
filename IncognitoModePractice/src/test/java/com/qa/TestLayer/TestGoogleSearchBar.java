package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.Pagelayer.GoogleSearchBar;
import com.qa.TestBase.TestBase;

public class TestGoogleSearchBar extends TestBase {
	
	@Test
	public void verifyGoogleSearchBar()
	{
		GoogleSearchBar gsb = new GoogleSearchBar();
		gsb.enterSearchContent("Shubham");
	}
}

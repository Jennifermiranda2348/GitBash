package com.practice.gitbash;


import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class Test2 extends BaseClass{
	@Test(groups = {"smoke","regression"})
	public void trial() {
	System.out.println("Get trail free");
	}

}

package org.com.teja.WebApplicationXTest;

import static org.junit.Assert.*;

import org.com.teja.WebApplicationX.MyResource;
import org.junit.Before;
import org.junit.Test;

public class MyResourceTest {

	MyResource myResourceTestClass= new MyResource();
	

	@Test
	public void test() {
		assertEquals("Got it!", myResourceTestClass.getIt());	
	}

}

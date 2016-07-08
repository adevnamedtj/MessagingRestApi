package org.com.teja.WebApplicationXTest.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.com.teja.WebApplicationX.dao.Dao;
import org.junit.Test;

public class DaoTest {
	Dao DaoTestClass = new Dao();

	@Test
	public void test() {
		assertEquals(new ArrayList<Integer>(), DaoTestClass.getDeletedMessageList());
		
	}

}

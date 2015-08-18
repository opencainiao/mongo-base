package com.mou.mongodb.base.springmongo;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.mou.mongodb.base.Client;
import com.mou.mongodb.base.springdb.op.DeleteUtil;

public class TestDeleteUtil2 {

	@Test
	public void testRemoveByIdStringClassOfT() {

		String _id = "";
		int removeResultNum = DeleteUtil.removeById(_id, Client.class);
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByConditionQueryClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByConditionQueryString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdLogicStringClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdLogicStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByConditionLogicQueryClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByConditionLogicQueryString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdsLogicListOfStringClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdsLogicListOfStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdsListOfStringClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveByIdsListOfStringString() {
		fail("Not yet implemented");
	}

}

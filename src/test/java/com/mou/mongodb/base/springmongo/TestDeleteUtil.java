package com.mou.mongodb.base.springmongo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mou.mongodb.base.springdb.op.DeleteUtil;
import com.mou.mongodb.base.springmongo.domain.Client;

public class TestDeleteUtil {

	@Before
	public void setup() {
		new ClientTest().testInsert();
	}

	@Test
	public void testRemoveByIdStringClassOfT() {

		String _id = "55d3ffca7d017c1ce8e5ede4";
		int removeResultNum = DeleteUtil.removeById(_id, Client.class);
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdStringString() {

		String _id = "55d3ffca7d017c1ce8e5ede3";
		String collectionName = "client";
		int removeResultNum = DeleteUtil.removeById(_id, collectionName);
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByConditionQueryClassOfT() {

		Criteria criteria = Criteria.where("sex").is("1");
		Query query = new Query(criteria);
		int removeResultNum = DeleteUtil.removeByCondition(query, Client.class);
		System.out.println(removeResultNum);

	}

	@Test
	public void testRemoveByConditionQueryString() {

		Criteria criteria = Criteria.where("sex").is("1").and("client_name")
				.is("测试用户_1");
		Query query = new Query(criteria);
		int removeResultNum = DeleteUtil.removeByCondition(query, "client");
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdLogicStringClassOfT() {

		String _id = "55d4055c7d017c0e20191d80";
		int removeResultNum = DeleteUtil.removeByIdLogic(_id, Client.class);
		System.out.println(removeResultNum);

	}

	@Test
	public void testRemoveByIdLogicStringString() {

		String _id = "55d4055c7d017c0e20191d7f";
		int removeResultNum = DeleteUtil.removeByIdLogic(_id, "client");
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByConditionLogicQueryClassOfT() {

		Criteria criteria = Criteria.where("sex").is("1").and("client_name")
				.is("测试用户_2");
		Query query = new Query(criteria);
		int removeResultNum = DeleteUtil.removeByConditionLogic(query,
				Client.class);
		System.out.println(removeResultNum);

	}

	@Test
	public void testRemoveByConditionLogicQueryString() {

		Criteria criteria = Criteria.where("sex").is("1").and("client_name")
				.is("测试用户_0");
		Query query = new Query(criteria);
		int removeResultNum = DeleteUtil
				.removeByConditionLogic(query, "client");
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdsLogicListOfStringClassOfT() {

		List<String> _ids = new ArrayList<String>();

		_ids.add("55d407e57d017c067080ef1f");
		_ids.add("55d407e57d017c067080ef20");
		_ids.add("aree");

		int removeResultNum = DeleteUtil.removeByIdsLogic(_ids, Client.class);
		System.out.println(removeResultNum);

	}

	@Test
	public void testRemoveByIdsLogicListOfStringString() {

		List<String> _ids = new ArrayList<String>();

		_ids.add("55d409717d017c1fa84f0390");
		_ids.add("55d409717d017c1fa84f0391");
		_ids.add("55d409717d017c1fa84f0392");
		_ids.add("aree");

		int removeResultNum = DeleteUtil.removeByIdsLogic(_ids, "client");
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdsListOfStringClassOfT() {

		List<String> _ids = new ArrayList<String>();

		_ids.add("55d409717d017c1fa84f0391");
		_ids.add("55d409717d017c1fa84f0392");
		_ids.add("aree");

		int removeResultNum = DeleteUtil.removeByIds(_ids, Client.class);
		System.out.println(removeResultNum);
	}

	@Test
	public void testRemoveByIdsListOfStringString() {
		List<String> _ids = new ArrayList<String>();

		_ids.add("55d409717d017c1fa84f0390");
		_ids.add("aree");

		int removeResultNum = DeleteUtil.removeByIds(_ids, "client");
		System.out.println(removeResultNum);
	}

}

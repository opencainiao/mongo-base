package com.mou.mongodb.base.springmongo;

import org.junit.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mou.mongodb.base.springdb.db.op.DeleteUtil;
import com.mou.mongodb.base.springmongo.domain.Client;

public class TestDeleteUtil {

	@Test
	public void testRemoveByIdStringClassOfT() {

		String _id = "55cfeabd7db9c621d4f3991a";
		int n = DeleteUtil.removeById(_id, Client.class);

		System.out.println(n);
	}

	@Test
	public void testRemoveByIdStringString() {

		String _id = "55cfeabd7db9c621d4f39919";
		int n = DeleteUtil.removeById(_id, "client");

		System.out.println(n);

	}

	@Test
	public void testRemoveByConditionQueryClassOfT() {

		String client_name = "测试用户_0";

		Criteria criteria = Criteria.where("client_name").is(client_name);
		Query query = new Query(criteria);

		int n = DeleteUtil.removeByCondition(query, Client.class);

		System.out.println(n);
	}

	@Test
	public void testRemoveByConditionQueryString() {
		
		String client_name = "测试用户_1";

		Criteria criteria = Criteria.where("client_name").is(client_name);
		Query query = new Query(criteria);

		int n = DeleteUtil.removeByCondition(query, "client");

		System.out.println(n);
	}

}

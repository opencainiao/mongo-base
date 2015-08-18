package com.mou.mongodb.base.springmongo;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mou.mongodb.base.Client;
import com.mou.mongodb.base.springdb.op.UpdateUtil;

public class TestUpdate {

	@Test
	public void testUpdateOneByIdStringDBObjectDBObjectClassOfT() {

		String _id = "55d2ab54eae97c02d49362ea";

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("education_type", "12345");
		updateSet.put("birth_date", "12345");
		update.put("$set", updateSet);

		DBObject returnFields = null;
		DBObject upResult = UpdateUtil.updateOneById(_id, returnFields, update,
				Client.class);
		System.out.println(upResult);
	}

	@Test
	public void testUpdateOneByIdStringDBObjectDBObjectString() {

		String _id = "55d2adadeae97c06a4ddd8f2";

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("education_type", "123456");
		updateSet.put("birth_date", "123456");
		update.put("$set", updateSet);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("education_type", 0);
		returnFields.put("_id", 0);

		DBObject upResult = UpdateUtil.updateOneById(_id, returnFields, update,
				"client");

		System.out.println(upResult);
	}

	@Test
	public void testUpdateOneByConditionDBObjectDBObjectDBObjectBooleanClassOfT() {

		DBObject query = new BasicDBObject();
		query.put("sex", "1");

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("sex", "0");
		updateSet.put("birth_date", "111111");
		update.put("$set", updateSet);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("sex", 1);
		returnFields.put("birth_date", 1);

		DBObject upResult = UpdateUtil.updateOneByCondition(query,
				returnFields, update, false, Client.class);

		System.out.println(upResult);

		query = new BasicDBObject();
		query.put("sex", "0");

		update = new BasicDBObject();
		updateSet = new BasicDBObject();
		updateSet.put("sex", "0");
		updateSet.put("client_name", "测试11111");
		updateSet.put("nnn", "yes");
		update.put("$set", updateSet);

		returnFields = new BasicDBObject();
		returnFields.put("sex", 1);
		returnFields.put("client_name", 1);

		upResult = UpdateUtil.updateOneByCondition(query, returnFields, update,
				true, Client.class);

		System.out.println(upResult);

	}

	@Test
	public void testUpdateOneByConditionDBObjectDBObjectDBObjectBooleanString() {
		DBObject query = new BasicDBObject();
		query.put("sex", "0");

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("sex", "11");
		updateSet.put("birth_date", "333333");
		update.put("$set", updateSet);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("sex", 1);
		returnFields.put("birth_date", 1);

		DBObject upResult = UpdateUtil.updateOneByCondition(query,
				returnFields, update, false, "client");

		System.out.println(upResult);

		query = new BasicDBObject();
		query.put("sex", "0");

		update = new BasicDBObject();
		updateSet = new BasicDBObject();
		updateSet.put("sex", "0");
		updateSet.put("client_name", "测试22222");
		updateSet.put("nnn", "yes");
		update.put("$set", updateSet);

		returnFields = new BasicDBObject();
		returnFields.put("sex", 1);
		returnFields.put("client_name", 1);
		returnFields.put("nnn", 1);

		upResult = UpdateUtil.updateOneByCondition(query, returnFields, update,
				false, "client");

		System.out.println(upResult);
	}

	@Test
	public void testUpdateMultiByConditionClassOfTDBObjectDBObject() {
		
		DBObject query = new BasicDBObject();
		query.put("sex", "1");

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("sex", "0");
		updateSet.put("birth_date", "2015-01-01");
		update.put("$set", updateSet);

		WriteResult upResult = UpdateUtil.updateMultiByCondition
				(Client.class, query, update);

		System.out.println(upResult);
	}

	@Test
	public void testUpdateMultiByConditionStringDBObjectDBObject() {
		
		DBObject query = new BasicDBObject();
		query.put("sex", "0");

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("sex", "1");
		updateSet.put("birth_date", "2015-08-08");
		update.put("$set", updateSet);

		WriteResult upResult = UpdateUtil.updateMultiByCondition
				("client", query, update);

		System.out.println(upResult);
	}

}

package com.mou.mongodb.base.springmongo;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;
import com.mou.mongodb.base.springdb.op.FindOneUtil;

public class Person2Test {

	@Test
	public void test() {

		MongoOperations mongoOps = MongoTemplateHelper.getMongoTemplate();

		Person2 p2 = new Person2();
		p2.setAge(15);
		p2.setName("张三");
		p2.setDel_flg(false);

		mongoOps.insert(p2);

		ObjectId _id = p2.get_id();
		String _id_m = p2.get_id_m();

		System.out.println("_id [" + _id + "]");

		System.out.println("_id_m [" + _id_m + "]");
	}

	@Test
	public void testFind() {

		String _id = "55cf52e17db9c61acc27065a";

		DBObject fields = new BasicDBObject();
		fields.put("name", 1);
		fields.put("_id", -1);

		Person2 p2 = FindOneUtil.findOnePartById(_id, fields, Person2.class);

		System.out.println(p2);
	}

}

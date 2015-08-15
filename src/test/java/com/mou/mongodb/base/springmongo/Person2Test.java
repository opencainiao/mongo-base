package com.mou.mongodb.base.springmongo;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mou.mongodb.base.springdb.db.MongoTemplateHelper;

public class Person2Test {

	@Test
	public void test() {

		MongoOperations mongoOps = MongoTemplateHelper.getMongoTemplate("bxb_test");

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

}

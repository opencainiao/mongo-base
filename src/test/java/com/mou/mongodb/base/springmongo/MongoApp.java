package com.mou.mongodb.base.springmongo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mou.mongodb.base.springdb.db.MongoTemplateHelper;

public class MongoApp {

	private static final Log log = LogFactory.getLog(MongoApp.class);


	public static void main(String[] args) throws Exception {

		MongoOperations mongoOps = MongoTemplateHelper.getMongoTemplate("bxb_test");
		
		mongoOps.insert(new Person("Joe", 34));

		Person p = mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class);
		log.info(p);
	//	mongoOps.dropCollection("person");
	}
}

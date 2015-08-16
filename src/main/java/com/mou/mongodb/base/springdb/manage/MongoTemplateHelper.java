package com.mou.mongodb.base.springdb.manage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoTemplateHelper {

	public static ClassPathXmlApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("mongoContext.xml");
	}

	private MongoTemplateHelper() {
	}

	/****
	 * 取MongoOperations
	 * 
	 * @param databaseName
	 * @return
	 */
	public static MongoOperations getMongoTemplate() {

		return (MongoTemplate) context.getBean("mongoTemplate");

	}
}

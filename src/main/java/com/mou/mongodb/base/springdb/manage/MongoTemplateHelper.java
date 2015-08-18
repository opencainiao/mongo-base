package com.mou.mongodb.base.springdb.manage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBCollection;

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

	/****
	 * 取DBCollection
	 * 
	 * @param entityClass
	 * @return
	 */
	public static <T> DBCollection getCollection(Class<T> entityClass) {

		MongoOperations op = getMongoTemplate();
		String collectionName = op.getCollectionName(entityClass);
		DBCollection collection = op.getCollection(collectionName);

		return collection;
	}

	/****
	 * 取DBCollection
	 * 
	 * @param collectionName
	 * @return
	 */
	public static <T> DBCollection getCollection(String collectionName) {

		MongoOperations op = getMongoTemplate();
		DBCollection collection = op.getCollection(collectionName);

		return collection;
	}
}

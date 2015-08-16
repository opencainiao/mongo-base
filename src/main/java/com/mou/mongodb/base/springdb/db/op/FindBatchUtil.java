package com.mou.mongodb.base.springdb.db.op;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.db.MongoTemplateHelper;
import com.mou.mongodb.base.util.SetInfUtil;

/****
 * 批量查询的帮助类
 * 
 * @author NBQ
 *
 */
public class FindBatchUtil {

	/****
	 * 查询全部
	 * 
	 * @param entityClass
	 * @return
	 */
	public static <T> List<T> findAll(Class<T> entityClass) {
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findAll(entityClass);
	}

	/****
	 * 查询全部
	 * 
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> List<T> findAll(Class<T> entityClass, String collectionName) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findAll(entityClass, collectionName);
	}

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public static <T> List<T> findBatch(Query query, Class<T> entityClass) {
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.find(query, entityClass);
	}

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public static <T> List<T> findBatch(Query query, Class<T> entityClass, String collectionName) {
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.find(query, entityClass, collectionName);
	}

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public static <T> List<T> findBatchPart(Query query, DBObject returnFields, Class<T> entityClass) {

		SetInfUtil.setReturnFields(query, returnFields);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.find(query, entityClass);
	}

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> List<T> findBatchPart(Query query, DBObject returnFields, Class<T> entityClass,
			String collectionName) {

		SetInfUtil.setReturnFields(query, returnFields);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.find(query, entityClass, collectionName);
	}

}

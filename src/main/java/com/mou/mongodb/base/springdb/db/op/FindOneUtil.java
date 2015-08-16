package com.mou.mongodb.base.springdb.db.op;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.db.MongoTemplateHelper;
import com.mou.mongodb.base.util.SetInfUtil;

public class FindOneUtil {

	/****
	 * 查询一个对象
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> T findOneById(String _id, Class<T> entityClass) {
		if (!ObjectId.isValid(_id)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findById(_id, entityClass);
	}

	/****
	 * 查询一个对象
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> T findOneById(String _id, Class<T> entityClass, String collectionName) {
		if (!ObjectId.isValid(_id)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findById(_id, entityClass, collectionName);
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public static <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass) {

		if (!ObjectId.isValid(_id)) {
			return null;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);
		SetInfUtil.setReturnFields(query, returnFields);
		
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass);
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass,
			String collectionName) {

		if (!ObjectId.isValid(_id)) {
			return null;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);
		SetInfUtil.setReturnFields(query, returnFields);
		
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass, collectionName);
	}

	/****
	 * 查询一个对象
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public static <T> T findOne(Query query, Class<T> entityClass) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass);
	}

	/****
	 * 查询一个对象
	 * 
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> T findOne(Query query, Class<T> entityClass, String collectionName) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass, collectionName);
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public static <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass) {

		SetInfUtil.setReturnFields(query, returnFields);
		
		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass);
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass, String collectionName) {

		SetInfUtil.setReturnFields(query, returnFields);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.findOne(query, entityClass, collectionName);
	}
}

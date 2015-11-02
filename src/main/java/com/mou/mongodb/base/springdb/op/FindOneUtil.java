package com.mou.mongodb.base.springdb.op;

import org.bson.types.ObjectId;
import org.mou.common.StringUtil;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;
import com.mou.mongodb.base.util.EntityClassUtil;
import com.mou.mongodb.base.util.SetInfUtil;

/****
 * 查询单条数据的帮助类
 * 
 * @author NBQ
 *
 */
public class FindOneUtil {

	public static <T> boolean isExist(DBObject query, Class<T> entityClass) {

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return false;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int count = coll.find(query).count();

		return count == 0 ? false : true;
	}

	public static <T> boolean isExist(DBObject query, Class<T> entityClass, String collectionNameIn) {

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return false;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int count = coll.find(query).count();

		return count == 0 ? false : true;
	}

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

		T returnObj = op.findById(_id, entityClass);

		if (returnObj instanceof BaseModel) {
			((BaseModel) returnObj).set_id_m(((BaseModel) returnObj).get_id_m());
		}

		return returnObj;
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

		T returnObj = op.findById(_id, entityClass, collectionName);

		if (returnObj instanceof BaseModel) {
			((BaseModel) returnObj).set_id_m(((BaseModel) returnObj).get_id_m());
		}

		return returnObj;
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

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param entityClass
	 * @param collectionNameIn
	 * @param query
	 * @param returnFields
	 * @return
	 */
	public static <T> T findOnePart(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject returnFields) {

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBObject object = coll.findOne(query, returnFields);

		if (object != null) {
			MongoConverter converter = op.getConverter();
			return converter.read(entityClass, object);
		}

		return null;
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param entityClass
	 * @param query
	 * @param returnFields
	 * @return
	 */
	public static <T> T findOnePart(Class<T> entityClass, DBObject query, DBObject returnFields) {

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBObject object = coll.findOne(query, returnFields);

		if (object != null) {
			MongoConverter converter = op.getConverter();
			return converter.read(entityClass, object);
		}

		return null;
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param entityClass
	 * @param collectionNameIn
	 * @param query
	 * @param returnFields
	 * @return
	 */
	public static <T> DBObject findOnePartDBObject(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject returnFields) {

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBObject object = coll.findOne(query, returnFields);

		return object;
	}

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param entityClass
	 * @param query
	 * @param returnFields
	 * @return
	 */
	public static <T> DBObject findOnePartDBObject(Class<T> entityClass, DBObject query, DBObject returnFields) {

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return null;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBObject object = coll.findOne(query, returnFields);

		return object;
	}
}

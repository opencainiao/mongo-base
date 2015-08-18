package com.mou.mongodb.base.springdb.op;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;

public class UpdateUtil {

	/****
	 * 根据主键，更新一条记录
	 * 
	 * @param _id
	 * @param returnFields
	 * @param update
	 * @param entityClass
	 * @return
	 */
	public static <T> DBObject updateOneById(String _id, DBObject returnFields,
			DBObject update, Class<T> entityClass) {

		if (!ObjectId.isValid(_id)) {
			return null;
		}

		DBCollection collection = MongoTemplateHelper
				.getCollection(entityClass);

		DBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
		query.put("del_flg", "0");

		return collection.findAndModify(query, returnFields, null, false,
				update, true, false);
	}

	/****
	 * 根据主键，更新一条记录
	 * 
	 * @param _id
	 * @param returnFields
	 * @param update
	 * @param collectionName
	 * @return
	 */
	public static <T> DBObject updateOneById(String _id, DBObject returnFields,
			DBObject update, String collectionName) {

		if (!ObjectId.isValid(_id)) {
			return null;
		}

		DBCollection collection = MongoTemplateHelper
				.getCollection(collectionName);

		DBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));
		query.put("del_flg", "0");

		return collection.findAndModify(query, returnFields, null, false,
				update, true, false);
	}

	/****
	 * 根据条件，更新一条记录
	 * 
	 * @param query
	 * @param returnFields
	 * @param update
	 * @param upsert
	 * @param entityClass
	 * @return
	 */
	public static <T> DBObject updateOneByCondition(DBObject query,
			DBObject returnFields, DBObject update, boolean upsert,
			Class<T> entityClass) {

		query.put("del_flg", "0");

		DBCollection collection = MongoTemplateHelper
				.getCollection(entityClass);

		return collection.findAndModify(query, returnFields, null, false,
				update, true, upsert);
	}

	/****
	 * 根据条件，更新一条记录
	 * 
	 * @param query
	 * @param returnFields
	 * @param update
	 * @param upsert
	 * @param collectionName
	 * @return
	 */
	public static <T> DBObject updateOneByCondition(DBObject query,
			DBObject returnFields, DBObject update, boolean upsert,
			String collectionName) {

		query.put("del_flg", "0");

		DBCollection collection = MongoTemplateHelper
				.getCollection(collectionName);

		return collection.findAndModify(query, returnFields, null, false,
				update, true, upsert);
	}

	/****
	 * 根据条件更新数据，如果有多条，则全部更新
	 * 
	 * @param entityClass
	 * @param query
	 * @param update
	 * @return
	 */
	public static <T> WriteResult updateMultiByCondition(Class<T> entityClass,
			final DBObject query, final DBObject update) {

		query.put("del_flg", "0");

		DBCollection collection = MongoTemplateHelper
				.getCollection(entityClass);
		WriteConcern writeConcern = collection.getWriteConcern();
		return collection.update(query, update, false, true, writeConcern);
	}

	/****
	 * 根据条件更新数据，如果有多条，则全部更新
	 * 
	 * @param collectionName
	 * @param query
	 * @param update
	 * @return
	 */
	public static <T> WriteResult updateMultiByCondition(String collectionName,
			final DBObject query, final DBObject update) {

		query.put("del_flg", "0");

		DBCollection collection = MongoTemplateHelper
				.getCollection(collectionName);
		WriteConcern writeConcern = collection.getWriteConcern();
		return collection.update(query, update, false, true, writeConcern);
	}

}

package com.mou.mongodb.base.oridb.op;

import org.bson.types.ObjectId;

import com.mongodb.DBObject;
import com.mou.mongodb.base.oridb.manage.DBCollectionUtil;
import com.mou.mongodb.base.util.Convertor;

public class FindOneUtil {

	/****
	 * 查询一个对象
	 * 
	 * @param collectionName
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static DBObject findOneDBObjectById(String collectionName, String id) throws Exception {

		if (!ObjectId.isValid(id)) {
			return null;
		}
		return DBCollectionUtil.getMongoCollection(collectionName).findOne(new ObjectId(id));
	}

	/****
	 * 查询一个对象
	 * 
	 * @param collectionName
	 * @param id
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T findOneBeanById(String collectionName, String id, Class<T> clazz) throws Exception {

		if (!ObjectId.isValid(id)) {
			return null;
		}

		DBObject dbo = findOneDBObjectById(collectionName, id);
		return Convertor.dbObject2Bean(dbo, clazz);
	}

}

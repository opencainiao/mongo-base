package com.mou.mongodb.base.oridb.op;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.oridb.manage.DBCollectionUtil;
import com.mou.mongodb.base.util.Convertor;

public class MongoInsertUtil {

	/****
	 * 插入一个对象
	 * 
	 * @param collectionName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static String insertOne(String collectionName, BaseModel model) throws Exception {

		DBObject dbo = Convertor.bean2DBObject(model);
		DBCollectionUtil.getMongoCollection(collectionName).insert(dbo);

		return dbo.get("_id").toString();
	}

	
}

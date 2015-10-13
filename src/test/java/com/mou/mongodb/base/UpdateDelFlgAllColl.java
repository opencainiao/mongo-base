package com.mou.mongodb.base;

import java.util.Set;

import org.mou.common.JsonUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mou.mongodb.base.oridb.manage.MongoManager;

public class UpdateDelFlgAllColl {

	public static void updateDelFlg() {

		DB db = MongoManager.getDB("bxb");

		Set<String> collectionNames = db.getCollectionNames();

		System.out.println(JsonUtil.getPrettyJsonStr(collectionNames));

		for (String collectionName : collectionNames) {

			if (collectionName.indexOf(".") >= 0) {
				continue;
			}
			DBCollection collection = db.getCollection(collectionName);

			DBObject query = new BasicDBObject();
			query.put("delflg","0");

			DBObject update = new BasicDBObject();
			DBObject updateSet = new BasicDBObject();
			updateSet.put("del_flg", "0");
			update.put("$set", updateSet);
			
			WriteResult wr = collection.updateMulti(query, update);

			System.out.println(collectionName + "[" + wr.getN() + "]");
		}
	}

	public static void main(String[] args) {
		updateDelFlg();
	}
}

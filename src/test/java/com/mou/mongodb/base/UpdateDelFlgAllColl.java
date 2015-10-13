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
			query.put("delflg", "0");

			DBObject update = new BasicDBObject();
			DBObject updateSet = new BasicDBObject();
			updateSet.put("del_flg", "0");
			update.put("$set", updateSet);

			WriteResult wr = collection.updateMulti(query, update);

			System.out.println(collectionName + "del_flg[" + wr.getN() + "]");

			System.out.println(collectionName + "rename-useflg[" + wr.getN() + "]");
		}
	}

	/****
	 * 重命名所有表列
	 */
	public static void renameAllCollection(String oldCol, String newCol) {
		DB db = MongoManager.getDB("bxb");

		Set<String> collectionNames = db.getCollectionNames();

		System.out.println(JsonUtil.getPrettyJsonStr(collectionNames));

		for (String collectionName : collectionNames) {

			if (collectionName.indexOf(".") >= 0) {
				continue;
			}
			DBCollection collection = db.getCollection(collectionName);

			reNameCol(oldCol, newCol, collection);
		}
	}

	/****
	 * 重命名列
	 * 
	 * @param oldName
	 * @param newName
	 * @param collection
	 */
	public static void reNameCol(String oldName, String newName, DBCollection collection) {

		DBObject query = new BasicDBObject();
		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put(oldName, newName);
		update.put("$rename", updateSet);

		WriteResult wr = collection.updateMulti(query, update);

		System.out.println(collection.getName() + "--rename(" + oldName + "-->" + newName + ")[" + wr.getN() + "]");

	}

	/****
	 * 删除列
	 * 
	 * @param oldName
	 * @param newName
	 * @param collection
	 */
	public static void delCol(String colName, DBCollection collection) {

		DBObject query = new BasicDBObject();
		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put(colName, 1);
		update.put("$unset", updateSet);

		WriteResult wr = collection.updateMulti(query, update);

		System.out.println(collection.getName() + "--delCol(" + colName + ")[" + wr.getN() + "]");

	}

	/****
	 * 删除所有表列
	 */
	public static void delColAllCollection(String colName) {
		DB db = MongoManager.getDB("bxb");

		Set<String> collectionNames = db.getCollectionNames();

		System.out.println(JsonUtil.getPrettyJsonStr(collectionNames));

		for (String collectionName : collectionNames) {

			if (collectionName.indexOf(".") >= 0) {
				continue;
			}
			DBCollection collection = db.getCollection(collectionName);

			delCol(colName, collection);
		}
	}

	public static void main(String[] args) {
		// updateDelFlg();

		renameAllCollection("useflg", "use_flg");

		renameAllCollection("delflg", "del_flg");

		// delColAllCollection("use_flg");
	}
}

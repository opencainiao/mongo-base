package com.mou.mongodb.base.db.manage;

import com.mongodb.DBCollection;

public class DBCollectionUtil {

	/****
	 * 取Collection
	 * 
	 * @param collectionName
	 * @return
	 */
	public static DBCollection getMongoCollection(String collectionName) {

		return MongoManager.getDB().getCollection(collectionName);
	}

	/***
	 * 取collectionInf
	 * 
	 * @param collectionName
	 * @return
	 */
	public static String getCollectionInfo(String collectionName) {
		DBCollection coll = getMongoCollection(collectionName);

		StringBuffer sb = new StringBuffer();
		sb.append("------------------------------------\n");
		sb.append(coll.toString()).append("\n");
		sb.append(coll.getName()).append("\n");
		sb.append(coll.getFullName()).append("\n");
		sb.append("count---[" + coll.count() + "]").append("\n");
		sb.append(coll.getStats()).append("\n");

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getCollectionInfo("aaa"));
	}
}

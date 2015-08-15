package com.mou.mongodb.base.springdb.db;

import java.util.HashMap;
import java.util.Map;

import org.mou.common.StringUtil;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mou.mongodb.base.db.manage.MongoManager;

public class MongoTemplateHelper {

	private static Map<String, MongoOperations> mongoOperations = new HashMap<String, MongoOperations>();
	private static final String SYNC_FLG = "1";

	private static String defaultDatabaseName;

	public static String getDefaultDatabaseName() {
		return defaultDatabaseName;
	}

	public static void setDefaultDatabaseName(String defaultDatabaseName) {
		MongoTemplateHelper.defaultDatabaseName = defaultDatabaseName;
	}

	private static void init(String databaseName, UserCredentials userCredentials) {

		if (StringUtil.isEmpty(databaseName)) {
			return;
		}

		String key = makeKey(databaseName, userCredentials);

		synchronized (SYNC_FLG) {
			if (mongoOperations.get(key) != null) {
				return;
			}
		}

		MongoClient client = MongoManager.getMongoClient();
		MongoOperations mongoOps = new MongoTemplate(client, databaseName, userCredentials);
		mongoOperations.put(key, mongoOps);
	}

	private static String makeKey(String databaseName, UserCredentials userCredentials) {
		String username = "";
		String password = "";

		if (userCredentials != null) {
			username = userCredentials.getUsername();
			password = userCredentials.getPassword();
		}

		String key = databaseName + username + password;

		return key;
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

		if (StringUtil.isEmpty(defaultDatabaseName)) {
			setDefaultDatabaseName("bxb_test");
		}

		return getMongoTemplate(defaultDatabaseName);
	}

	/****
	 * 取MongoOperations
	 * 
	 * @param databaseName
	 * @return
	 */
	public static MongoOperations getMongoTemplate(String databaseName) {

		String key = makeKey(databaseName, null);

		if (mongoOperations.get(key) == null) {
			init(databaseName, null);
		}

		return mongoOperations.get(key);
	}

	/****
	 * 取MongoOperations
	 * 
	 * @param databaseName
	 * @param username
	 * @param password
	 * @return
	 */
	public static MongoOperations getMongoTemplate(String databaseName, String username, String password) {

		UserCredentials userCredentials = new UserCredentials(username, password);

		String key = makeKey(databaseName, userCredentials);

		if (mongoOperations.get(key) == null) {
			init(databaseName, userCredentials);
		}

		return mongoOperations.get(key);
	}

}

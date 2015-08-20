package com.mou.mongodb.base.oridb.manage;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoManager {

	private static MongoClient mongoClient = null;
	private static DB db = null;
	private static String dbname = "bxb_test";

	private static final String INIT_FLAG = "1";

	private MongoManager() {

	}

	public static DB getDB() {

		if (db == null) {
			db = getMongoClient().getDB(dbname);
		}

		return db;
	}

	/**
	 * 根据名称获取DB，相当于是连接
	 * 
	 * @param dbName
	 * @return
	 */
	public static DB getDB(String dbName) {
		return getMongoClient().getDB(dbName);
	}

	/****
	 * 获取MongoClient
	 * 
	 * @return
	 */
	public static MongoClient getMongoClient() {
		if (mongoClient == null) {
			init();
		}

		return mongoClient;
	}

	private MongoClientOptions getConfOptions() {
		return new MongoClientOptions.Builder().socketKeepAlive(true) // 是否保持长链接
				.connectTimeout(5000) // 链接超时时间
				.socketTimeout(5000) // read数据超时时间
				.readPreference(ReadPreference.primary()) // 最近优先策略
				.connectionsPerHost(30) // 每个地址最大请求数
				.maxWaitTime(1000 * 60 * 2) // 长链接的最大等待时间
				.threadsAllowedToBlockForConnectionMultiplier(50) // 一个socket最大的等待请求数
				.writeConcern(WriteConcern.NORMAL).build();
	}

	/**
	 * 初始化连接池，设置参数。
	 */
	private static void init() {

		synchronized (INIT_FLAG) {
			if (mongoClient != null) {
				return;
			}
		}

		// String host = "182.92.114.61";// 主机名
		 String host = "localhost";// 主机名
		int port = 27017;// 端口

		// 其他参数根据实际情况进行添加
		try {
			ServerAddress sa = new ServerAddress(host, port);
			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
			build.connectionsPerHost(50); // 与目标数据库能够建立的最大connection数量为50

			// 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
			build.threadsAllowedToBlockForConnectionMultiplier(50);

			/*
			 * 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
			 * 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
			 * 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
			 */
			build.maxWaitTime(1000 * 60 * 2);
			build.connectTimeout(1000 * 60 * 1); // 与数据库建立连接的timeout设置为1分钟
			MongoClientOptions myOptions = build.build();

			mongoClient = new MongoClient(sa, myOptions);
		} catch (Exception e) {
			System.out.println("数据库初始化错误");
			System.exit(1);
		}
	}
}

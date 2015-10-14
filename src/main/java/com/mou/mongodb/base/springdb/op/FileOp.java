package com.mou.mongodb.base.springdb.op;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;

public class FileOp {

	private static final Logger logger = LogManager.getLogger(FileOp.class);

	public static String saveFile(InputStream inputStream, String newFileName) {

		MongoTemplate op = MongoTemplateHelper.getMongoTemplate();
		DB db = op.getDb();

		GridFS gridFS = new GridFS(db);
		GridFSInputFile gridFSInputFile = gridFS.createFile(inputStream, newFileName);
		gridFSInputFile.save();

		String _id = ((ObjectId) (gridFSInputFile.get("_id"))).toString();

		logger.debug("保存到数据库，数据库的_id是{}", _id);
		logger.debug("保存到数据库，文件的md5是{}", gridFSInputFile.getMD5());

		return _id;
	}

	public static String saveFile(File file) throws IOException {

		MongoTemplate op = MongoTemplateHelper.getMongoTemplate();
		DB db = op.getDb();

		GridFS gridFS = new GridFS(db);

		GridFSInputFile gridFSInputFile = gridFS.createFile(file);
		gridFSInputFile.save();

		String _id = ((ObjectId) (gridFSInputFile.get("_id"))).toString();
		
		logger.debug("保存到数据库，数据库的_id是{}", _id);
		logger.debug("保存到数据库，文件的md5是{}", gridFSInputFile.getMD5());

		return _id;
	}

	public static void removeFile(String fileId) {

		MongoTemplate op = MongoTemplateHelper.getMongoTemplate();
		DB db = op.getDb();

		GridFS gridFS = new GridFS(db);
		gridFS.remove(new ObjectId(fileId));
	}
	
	public static GridFSDBFile findFileBy_Id(String _id) {

		MongoTemplate op = MongoTemplateHelper.getMongoTemplate();
		DB db = op.getDb();
		GridFS gridFS = new GridFS(db);
		return gridFS.findOne(new ObjectId(_id));
	}
	
	
}

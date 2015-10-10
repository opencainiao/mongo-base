package com.mou.mongodb.base.springdb.op;

import java.util.ArrayList;
import java.util.List;

import org.mou.common.StringUtil;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;
import com.mou.mongodb.base.util.EntityClassUtil;

/****
 * 批量查询的帮助类(使用原生mongodb-driver)
 * 
 * @author NBQ
 *
 */
public class FindBatchUtilOri {

	public static <T> List<T> findAll(DBObject orderBy, Class<T> entityClass) {
		List<T> result = new ArrayList<T>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);
		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(null, null).sort(orderBy);
			} else {
				cursor = coll.find(null, null);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findAll(DBObject orderBy, Class<T> entityClass, String collectionNameIn) {
		List<T> result = new ArrayList<T>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(null, null).sort(orderBy);
			} else {
				cursor = coll.find(null, null);
			}

			MongoConverter converter = op.getConverter();

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass) {
		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);
		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(null, null).sort(orderBy);
			} else {
				cursor = coll.find(null, null);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass, String collectionNameIn) {
		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(null, null).sort(orderBy);
			} else {
				cursor = coll.find(null, null);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatch(Class<T> entityClass, DBObject query, DBObject orderBy) {

		List<T> result = new ArrayList<T>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);
		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy);
			} else {
				cursor = coll.find(query, null);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatch(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy) {

		List<T> result = new ArrayList<T>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy);
			} else {
				cursor = coll.find(query, null);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, Class<T> entityClass) {

		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);
		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy);
			} else {
				cursor = coll.find(query, null);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, String collectionName) {

		List<DBObject> result = new ArrayList<DBObject>();

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy);
			} else {
				cursor = coll.find(query, null);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatchPart(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		List<T> result = new ArrayList<T>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy);
			} else {
				cursor = coll.find(query, returnFields);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatchPart(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy, DBObject returnFields) {

		List<T> result = new ArrayList<T>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy);
			} else {
				cursor = coll.find(query, returnFields);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchPartDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy);
			} else {
				cursor = coll.find(query, returnFields);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static List<DBObject> findBatchPartDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		List<DBObject> result = new ArrayList<DBObject>();

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy);
			} else {
				cursor = coll.find(query, returnFields);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatchPage(Class<T> entityClass, DBObject query, DBObject orderBy, PageVO pageVO) {

		List<T> result = new ArrayList<T>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, null).skip(skip).limit(limit);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatchPage(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy, PageVO pageVO) {

		List<T> result = new ArrayList<T>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, null).skip(skip).limit(limit);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<T> findBatchPagePart(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO) {

		List<T> result = new ArrayList<T>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, returnFields).skip(skip).limit(limit);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;

	}

	public static <T> List<T> findBatchPagePart(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy, DBObject returnFields, PageVO pageVO) {

		List<T> result = new ArrayList<T>();

		String collectionName = collectionNameIn;
		if (collectionName == null) {
			collectionName = EntityClassUtil.getCollectionName(entityClass);
		}

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, returnFields).skip(skip).limit(limit);
			}

			MongoConverter converter = op.getConverter();
			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(converter.read(entityClass, object));
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchPageDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			PageVO pageVO) {

		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, null).skip(skip).limit(limit);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchPageDBObject(String collectionName, DBObject query, DBObject orderBy,
			PageVO pageVO) {

		List<DBObject> result = new ArrayList<DBObject>();

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, null).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, null).skip(skip).limit(limit);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}

	public static <T> List<DBObject> findBatchPagePartDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO) {

		List<DBObject> result = new ArrayList<DBObject>();

		String collectionName = EntityClassUtil.getCollectionName(entityClass);

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, returnFields).skip(skip).limit(limit);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;

	}

	public static <T> List<DBObject> findBatchPagePartDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO) {

		List<DBObject> result = new ArrayList<DBObject>();

		if (StringUtil.isEmpty(collectionName)) {
			return result;
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		DBCollection coll = op.getCollection(collectionName);

		int limit = 10;// 默认查十条
		int skip = 0;
		if (pageVO != null) {
			limit = pageVO.getPageCount();
			skip = pageVO.getStartOffset();
		}

		DBCursor cursor = null;

		try {

			if (orderBy != null) {
				cursor = coll.find(query, returnFields).sort(orderBy).skip(skip).limit(limit);
			} else {
				cursor = coll.find(query, returnFields).skip(skip).limit(limit);
			}

			while (cursor.hasNext()) {
				DBObject object = cursor.next();

				result.add(object);
			}
		} finally {

			if (cursor != null) {
				cursor.close();
			}
		}

		return result;
	}
}

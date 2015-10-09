package com.mou.mongodb.base.springdb.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.op.DeleteUtil;
import com.mou.mongodb.base.springdb.op.FindBatchUtil;
import com.mou.mongodb.base.springdb.op.FindBatchUtilOri;
import com.mou.mongodb.base.springdb.op.FindOneUtil;
import com.mou.mongodb.base.springdb.op.InsertUtil;
import com.mou.mongodb.base.springdb.op.UpdateUtil;

@Repository("commonDaoMongo")
public class CommonDaoMongo implements IBaseDaoMongo {

	public String insertOne(BaseModel model) {
		return InsertUtil.insertOne(model);
	}

	public List<String> insertAll(List<? extends BaseModel> models) {
		return InsertUtil.insertAll(models);
	}

	public <T> int removeById(String _id, Class<T> entityClass) {
		return DeleteUtil.removeById(_id, entityClass);
	}

	public int removeById(String _id, String collectionName) {
		return DeleteUtil.removeById(_id, collectionName);
	}

	public <T> int removeByCondition(Query query, Class<T> entityClass) {
		return DeleteUtil.removeByCondition(query, entityClass);
	}

	public int removeByCondition(Query query, String collectionName) {
		return DeleteUtil.removeByCondition(query, collectionName);
	}

	public <T> int removeByIdLogic(String _id, Class<T> entityClass) {
		return DeleteUtil.removeByIdLogic(_id, entityClass);
	}

	public int removeByIdLogic(String _id, String collectionName) {
		return DeleteUtil.removeByIdLogic(_id, collectionName);
	}

	public <T> int removeByConditionLogic(Query query, Class<T> entityClass) {
		return DeleteUtil.removeByConditionLogic(query, entityClass);
	}

	public int removeByConditionLogic(Query query, String collectionName) {
		return DeleteUtil.removeByConditionLogic(query, collectionName);
	}

	public <T> int removeByIdsLogic(List<String> _ids, Class<T> entityClass) {
		return DeleteUtil.removeByIdsLogic(_ids, entityClass);
	}

	public int removeByIdsLogic(List<String> _ids, String collectionName) {
		return DeleteUtil.removeByIdsLogic(_ids, collectionName);
	}

	public <T> int removeByIds(List<String> _ids, Class<T> entityClass) {
		return DeleteUtil.removeByIds(_ids, entityClass);
	}

	public int removeByIds(List<String> _ids, String collectionName) {
		return DeleteUtil.removeByIds(_ids, collectionName);
	}

	public <T> T findOneById(String _id, Class<T> entityClass) {
		return FindOneUtil.findOneById(_id, entityClass);
	}

	public <T> T findOneById(String _id, Class<T> entityClass, String collectionName) {
		return FindOneUtil.findOneById(_id, entityClass, collectionName);
	}

	public <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass) {
		return FindOneUtil.findOnePartById(_id, returnFields, entityClass);
	}

	public <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass, String collectionName) {
		return FindOneUtil.findOnePartById(_id, returnFields, entityClass, collectionName);
	}

	public <T> T findOne(Query query, Class<T> entityClass) {
		return FindOneUtil.findOne(query, entityClass);
	}

	public <T> T findOne(Query query, Class<T> entityClass, String collectionName) {
		return FindOneUtil.findOne(query, entityClass, collectionName);
	}

	public <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass) {
		return FindOneUtil.findOnePart(query, returnFields, entityClass);
	}

	public <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass, String collectionName) {
		return FindOneUtil.findOnePart(query, returnFields, entityClass, collectionName);
	}

	public <T> List<T> findAll(Class<T> entityClass) {
		return FindBatchUtil.findAll(entityClass);
	}

	public <T> List<T> findAll(Class<T> entityClass, String collectionName) {
		return FindBatchUtil.findAll(entityClass, collectionName);
	}

	public <T> List<T> findBatch(Query query, Sort sort, Class<T> entityClass) {
		return FindBatchUtil.findBatch(query, sort, entityClass);
	}

	public <T> List<T> findBatch(Query query, Class<T> entityClass, Sort sort, String collectionName) {
		return FindBatchUtil.findBatch(query, entityClass, sort, collectionName);
	}

	public <T> List<T> findBatchPart(Query query, DBObject returnFields, Sort sort, Class<T> entityClass) {
		return FindBatchUtil.findBatchPart(query, returnFields, sort, entityClass);
	}

	public <T> List<T> findBatchPart(Query query, DBObject returnFields, Sort sort, Class<T> entityClass,
			String collectionName) {
		return FindBatchUtil.findBatchPart(query, returnFields, sort, entityClass, collectionName);
	}

	public <T> List<T> findBatchPage(Query query, Class<T> entityClass, PageVO pageVO, Sort sort) {
		return FindBatchUtil.findBatchPage(query, entityClass, pageVO, sort);
	}

	public <T> List<T> findBatchPage(Query query, Class<T> entityClass, String collectionName, PageVO pageVO,
			Sort sort) {
		return FindBatchUtil.findBatchPage(query, entityClass, collectionName, pageVO, sort);
	}

	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields, Class<T> entityClass, PageVO pageVO,
			Sort sort) {
		return FindBatchUtil.findBatchPartPage(query, returnFields, entityClass, pageVO, sort);
	}

	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields, Class<T> entityClass,
			String collectionName, PageVO pageVO, Sort sort) {
		return FindBatchUtil.findBatchPartPage(query, returnFields, entityClass, collectionName, pageVO, sort);
	}

	public <T> DBObject updateOneById(String _id, DBObject returnFields, DBObject update, Class<T> entityClass) {
		return UpdateUtil.updateOneById(_id, returnFields, update, entityClass);
	}

	public <T> DBObject updateOneById(String _id, DBObject returnFields, DBObject update, String collectionName) {
		return UpdateUtil.updateOneById(_id, returnFields, update, collectionName);
	}

	public <T> DBObject updateOneByCondition(DBObject query, DBObject returnFields, DBObject update, boolean upsert,
			Class<T> entityClass) {
		return UpdateUtil.updateOneByCondition(query, returnFields, update, upsert, entityClass);
	}

	public <T> DBObject updateOneByCondition(DBObject query, DBObject returnFields, DBObject update, boolean upsert,
			String collectionName) {
		return UpdateUtil.updateOneByCondition(query, returnFields, update, upsert, collectionName);
	}

	public <T> WriteResult updateMultiByCondition(Class<T> entityClass, DBObject query, DBObject update) {
		return UpdateUtil.updateMultiByCondition(entityClass, query, update);
	}

	public <T> WriteResult updateMultiByCondition(String collectionName, DBObject query, DBObject update) {
		return UpdateUtil.updateMultiByCondition(collectionName, query, update);
	}

	public <T> List<T> findAll(DBObject orderBy, Class<T> entityClass) {
		return FindBatchUtilOri.findAll(orderBy, entityClass);
	}

	public <T> List<T> findAll(DBObject orderBy, Class<T> entityClass, String collectionNameIn) {

		return FindBatchUtilOri.findAll(orderBy, entityClass, collectionNameIn);
	}

	public <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass) {

		return FindBatchUtilOri.findAllDBObject(orderBy, entityClass);
	}

	public <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass, String collectionNameIn) {

		return FindBatchUtilOri.findAllDBObject(orderBy, entityClass, collectionNameIn);

	}

	public <T> List<T> findBatch(Class<T> entityClass, DBObject query, DBObject orderBy) {

		return FindBatchUtilOri.findBatch(entityClass, query, orderBy);
	}

	public <T> List<T> findBatch(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy) {

		return FindBatchUtilOri.findBatch(entityClass, collectionNameIn, query, orderBy);

	}

	public <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, Class<T> entityClass) {

		return FindBatchUtilOri.findBatchDBObject(query, orderBy, entityClass);
	}

	public <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, String collectionName) {

		return FindBatchUtilOri.findBatchDBObject(query, orderBy, collectionName);
	}

	public <T> List<T> findBatchPart(Class<T> entityClass, DBObject query, DBObject orderBy, DBObject returnFields) {

		return FindBatchUtilOri.findBatchPart(entityClass, query, orderBy, returnFields);
	}

	public <T> List<T> findBatchPart(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		return FindBatchUtilOri.findBatchPart(entityClass, collectionNameIn, query, orderBy, returnFields);
	}

	public <T> List<DBObject> findBatchPartDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		return FindBatchUtilOri.findBatchPartDBObject(entityClass, query, orderBy, returnFields);
	}

	public List<DBObject> findBatchPartDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields) {

		return FindBatchUtilOri.findBatchPartDBObject(collectionName, query, orderBy, returnFields);
	}

	public <T> List<T> findBatchPage(Class<T> entityClass, DBObject query, DBObject orderBy, PageVO pageVO) {

		return FindBatchUtilOri.findBatchPage(entityClass, query, orderBy, pageVO);
	}

	public <T> List<T> findBatchPage(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy,
			PageVO pageVO) {
		return FindBatchUtilOri.findBatchPage(entityClass, collectionNameIn, query, orderBy, pageVO);
	}

	public <T> List<T> findBatchPartPage(Class<T> entityClass, DBObject query, DBObject orderBy, DBObject returnFields,
			PageVO pageVO) {

		return FindBatchUtilOri.findBatchPartPage(entityClass, query, orderBy, returnFields, pageVO);
	}

	public <T> List<T> findBatchPartPage(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy, DBObject returnFields, PageVO pageVO) {

		return FindBatchUtilOri.findBatchPartPage(entityClass, collectionNameIn, query, orderBy, returnFields, pageVO);
	}

	public <T> List<DBObject> findBatchPageDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			PageVO pageVO) {

		return FindBatchUtilOri.findBatchPageDBObject(entityClass, query, orderBy, pageVO);
	}

	public <T> List<DBObject> findBatchPageDBObject(String collectionName, DBObject query, DBObject orderBy,
			PageVO pageVO) {

		return FindBatchUtilOri.findBatchPageDBObject(collectionName, query, orderBy, pageVO);
	}

	public <T> List<DBObject> findBatchPartPageDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO) {

		return FindBatchUtilOri.findBatchPartPageDBObject(entityClass, query, orderBy, returnFields, pageVO);
	}

	public <T> List<DBObject> findBatchPartPageDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO) {

		return FindBatchUtilOri.findBatchPartPageDBObject(collectionName, query, orderBy, returnFields, pageVO);
	}
}

package com.mou.mongodb.base.springdb.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.domain.PageVO;

/****
 * 通用持久层基础类
 * 
 * @author NBQ
 *
 */
public interface IBaseDaoMongo {

	/****
	 * 插入一个对象
	 * 
	 * @param collectionName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String insertOne(BaseModel model);

	/****
	 * 插入一组对象
	 * 
	 * @param collectionName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<String> insertAll(List<? extends BaseModel> models);

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public <T> int removeById(String _id, Class<T> entityClass);

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public int removeById(String _id, String collectionName);

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public <T> int removeByCondition(Query query, Class<T> entityClass);

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public int removeByCondition(Query query, String collectionName);

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public <T> int removeByIdLogic(String _id, Class<T> entityClass);

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public int removeByIdLogic(String _id, String collectionName);

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public <T> int removeByConditionLogic(Query query, Class<T> entityClass);

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public int removeByConditionLogic(Query query, String collectionName);

	/****
	 * 删除数据，根据ids（逻辑删除）
	 * 
	 * @param _ids
	 * @return
	 */
	public <T> int removeByIdsLogic(List<String> _ids, Class<T> entityClass);

	/****
	 * 删除数据，根据ids（逻辑删除）
	 * 
	 * @param _ids
	 * @return
	 */
	public int removeByIdsLogic(List<String> _ids, String collectionName);

	/****
	 * 删除数据，根据ids
	 * 
	 * @param _ids
	 * @return
	 */
	public <T> int removeByIds(List<String> _ids, Class<T> entityClass);

	/****
	 * 删除数据，根据ids
	 * 
	 * @param _ids
	 * @return
	 */
	public int removeByIds(List<String> _ids, String collectionName);

	/****
	 * 查询一个对象
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public <T> T findOneById(String _id, Class<T> entityClass);

	/****
	 * 查询一个对象
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOneById(String _id, Class<T> entityClass, String collectionName);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOnePartById(String _id, DBObject returnFields, Class<T> entityClass, String collectionName);

	/****
	 * 查询一个对象
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> T findOne(Query query, Class<T> entityClass);

	/****
	 * 查询一个对象
	 * 
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOne(Query query, Class<T> entityClass, String collectionName);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOnePart(Query query, DBObject returnFields, Class<T> entityClass, String collectionName);

	/****
	 * 查询全部
	 * 
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findAll(Class<T> entityClass);

	/****
	 * 查询全部
	 * 
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findAll(Class<T> entityClass, String collectionName);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatch(Query query, Sort sort, Class<T> entityClass);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatch(Query query, Class<T> entityClass, Sort sort, String collectionName);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPart(Query query, DBObject returnFields, Sort sort, Class<T> entityClass);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findBatchPart(Query query, DBObject returnFields, Sort sort, Class<T> entityClass,
			String collectionName);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPage(Query query, Class<T> entityClass, PageVO pageVO, Sort sort);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPage(Query query, Class<T> entityClass, String collectionName, PageVO pageVO,
			Sort sort);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields, Class<T> entityClass, PageVO pageVO,
			Sort sort);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields, Class<T> entityClass,
			String collectionName, PageVO pageVO, Sort sort);

	/****
	 * 根据主键，更新一条记录
	 * 
	 * @param _id
	 * @param returnFields
	 * @param update
	 * @param entityClass
	 * @return
	 */
	public <T> DBObject updateOneById(String _id, DBObject returnFields, DBObject update, Class<T> entityClass);

	/****
	 * 根据主键，更新一条记录
	 * 
	 * @param _id
	 * @param returnFields
	 * @param update
	 * @param collectionName
	 * @return
	 */
	public <T> DBObject updateOneById(String _id, DBObject returnFields, DBObject update, String collectionName);

	/****
	 * 根据条件，更新一条记录
	 * 
	 * @param query
	 * @param returnFields
	 * @param update
	 * @param upsert
	 * @param entityClass
	 * @return
	 */
	public <T> DBObject updateOneByCondition(DBObject query, DBObject returnFields, DBObject update, boolean upsert,
			Class<T> entityClass);

	/****
	 * 根据条件，更新一条记录
	 * 
	 * @param query
	 * @param returnFields
	 * @param update
	 * @param upsert
	 * @param collectionName
	 * @return
	 */
	public <T> DBObject updateOneByCondition(DBObject query, DBObject returnFields, DBObject update, boolean upsert,
			String collectionName);

	/****
	 * 根据条件更新数据，如果有多条，则全部更新
	 * 
	 * @param entityClass
	 * @param query
	 * @param update
	 * @return
	 */
	public <T> WriteResult updateMultiByCondition(Class<T> entityClass, final DBObject query, final DBObject update);

	/****
	 * 根据条件更新数据，如果有多条，则全部更新
	 * 
	 * @param collectionName
	 * @param query
	 * @param update
	 * @return
	 */
	public <T> WriteResult updateMultiByCondition(String collectionName, final DBObject query, final DBObject update);

	public <T> List<T> findAll(DBObject orderBy, Class<T> entityClass);

	public <T> List<T> findAll(DBObject orderBy, Class<T> entityClass, String collectionNameIn);

	public <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass);

	public <T> List<DBObject> findAllDBObject(DBObject orderBy, Class<T> entityClass, String collectionNameIn);

	public <T> List<T> findBatch(Class<T> entityClass, DBObject query, DBObject orderBy);

	public <T> List<T> findBatch(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy);

	public <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, Class<T> entityClass);

	public <T> List<DBObject> findBatchDBObject(DBObject query, DBObject orderBy, String collectionName);

	public <T> List<T> findBatchPart(Class<T> entityClass, DBObject query, DBObject orderBy, DBObject returnFields);

	public <T> List<T> findBatchPart(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy,
			DBObject returnFields);

	public <T> List<DBObject> findBatchPartDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields);

	public List<DBObject> findBatchPartDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields);

	public <T> List<T> findBatchPage(Class<T> entityClass, DBObject query, DBObject orderBy, PageVO pageVO);

	public <T> List<T> findBatchPage(Class<T> entityClass, String collectionNameIn, DBObject query, DBObject orderBy,
			PageVO pageVO);

	public <T> List<T> findBatchPartPage(Class<T> entityClass, DBObject query, DBObject orderBy, DBObject returnFields,
			PageVO pageVO);

	public <T> List<T> findBatchPartPage(Class<T> entityClass, String collectionNameIn, DBObject query,
			DBObject orderBy, DBObject returnFields, PageVO pageVO);

	public <T> List<DBObject> findBatchPageDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			PageVO pageVO);

	public <T> List<DBObject> findBatchPageDBObject(String collectionName, DBObject query, DBObject orderBy,
			PageVO pageVO);

	public <T> List<DBObject> findBatchPartPageDBObject(Class<T> entityClass, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO);

	public <T> List<DBObject> findBatchPartPageDBObject(String collectionName, DBObject query, DBObject orderBy,
			DBObject returnFields, PageVO pageVO);
}

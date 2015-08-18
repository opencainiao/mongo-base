package com.mou.mongodb.base.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.domain.PageVO;

/****
 * 通用持久层基础类
 * 
 * @author NBQ
 *
 */
public interface IBaseDao {

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
	public <T> T findOneById(String _id, Class<T> entityClass,
			String collectionName);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> T findOnePartById(String _id, DBObject returnFields,
			Class<T> entityClass);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOnePartById(String _id, DBObject returnFields,
			Class<T> entityClass, String collectionName);

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
	public <T> T findOne(Query query, Class<T> entityClass,
			String collectionName);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param _id
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> T findOnePart(Query query, DBObject returnFields,
			Class<T> entityClass);

	/****
	 * 查询一个对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> T findOnePart(Query query, DBObject returnFields,
			Class<T> entityClass, String collectionName);

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
	public <T> List<T> findBatch(Query query, Class<T> entityClass, Sort sort,
			String collectionName);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPart(Query query, DBObject returnFields,
			Sort sort, Class<T> entityClass);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findBatchPart(Query query, DBObject returnFields,
			Sort sort, Class<T> entityClass, String collectionName);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPage(Query query, Class<T> entityClass,
			PageVO pageVO, Sort sort);

	/****
	 * 查询多条
	 * 
	 * @param query
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPage(Query query, Class<T> entityClass,
			String collectionName, PageVO pageVO, Sort sort);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields,
			Class<T> entityClass, PageVO pageVO, Sort sort);

	/****
	 * 查询多条对象的一部分
	 * 
	 * @param query
	 * @param returnFields
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findBatchPartPage(Query query, DBObject returnFields,
			Class<T> entityClass, String collectionName, PageVO pageVO,
			Sort sort);

	// -----------------------------------------------------------------------

	/****
	 * 更新一条记录，返回更新后的结果，根据查询条件
	 * 
	 * @param query
	 * @param returnFields
	 *            指定更新后返回的数据域
	 * @param update
	 * @param upsert
	 *            true-不存在则创建,false-不存在不处理
	 * @return
	 */
	public DBObject updateOneByCondition(DBObject query, DBObject returnFields,
			DBObject update, boolean upsert);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param _id
	 * @param returnFields
	 * @param update
	 * @return
	 */
	public DBObject updateOneById(String _id, DBObject returnFields,
			DBObject update);

}

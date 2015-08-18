package com.mou.mongodb.base.springdb.op;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;

/****
 * 删除数据的帮助类
 * 
 * @author NBQ
 *
 */
public class DeleteUtil {

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> int removeById(String _id, Class<T> entityClass) {

		if (!ObjectId.isValid(_id)) {
			return 0;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.remove(query, entityClass).getN();
	}

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static int removeById(String _id, String collectionName) {

		if (!ObjectId.isValid(_id)) {
			return 0;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.remove(query, collectionName).getN();
	}

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> int removeByCondition(Query query, Class<T> entityClass) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.remove(query, entityClass).getN();
	}

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static int removeByCondition(Query query, String collectionName) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		return op.remove(query, collectionName).getN();
	}

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> int removeByIdLogic(String _id, Class<T> entityClass) {

		if (!ObjectId.isValid(_id)) {
			return 0;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		Update update = new Update().set("delflg", "1");

		return op.updateFirst(query, update, entityClass).getN();

	}

	/****
	 * 删除一条
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static int removeByIdLogic(String _id, String collectionName) {

		if (!ObjectId.isValid(_id)) {
			return 0;
		}

		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		Update update = new Update().set("delflg", "1");

		return op.updateFirst(query, update, collectionName).getN();
	}

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> int removeByConditionLogic(Query query,
			Class<T> entityClass) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		Update update = new Update().set("delflg", "1");

		return op.updateMulti(query, update, entityClass).getN();
	}

	/****
	 * 删除全部满足条件的数据
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static int removeByConditionLogic(Query query, String collectionName) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		Update update = new Update().set("delflg", "1");

		return op.updateMulti(query, update, collectionName).getN();
	}

	/****
	 * 删除数据，根据ids（逻辑删除）
	 * 
	 * @param _ids
	 * @return
	 */
	public static <T> int removeByIdsLogic(List<String> _ids,
			Class<T> entityClass) {

		List<String> _idsNew = new ArrayList<String>();

		for (String _id : _ids) {
			if (ObjectId.isValid(_id)) {
				_idsNew.add(_id);
			}
		}

		Criteria criteria = Criteria.where("_id").in(_idsNew);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		Update update = new Update().set("delflg", "1");

		return op.updateFirst(query, update, entityClass).getN();
	}

	/****
	 * 删除数据，根据ids（逻辑删除）
	 * 
	 * @param _ids
	 * @return
	 */
	public static int removeByIdsLogic(List<String> _ids, String collectionName) {

		List<String> _idsNew = new ArrayList<String>();

		for (String _id : _ids) {
			if (ObjectId.isValid(_id)) {
				_idsNew.add(_id);
			}
		}

		Criteria criteria = Criteria.where("_id").in(_idsNew);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		Update update = new Update().set("delflg", "1");

		return op.updateFirst(query, update, collectionName).getN();
	}

	/****
	 * 删除数据，根据ids
	 * 
	 * @param _ids
	 * @return
	 */
	public static <T> int removeByIds(List<String> _ids, Class<T> entityClass) {

		List<String> _idsNew = new ArrayList<String>();

		for (String _id : _ids) {
			if (ObjectId.isValid(_id)) {
				_idsNew.add(_id);
			}
		}

		Criteria criteria = Criteria.where("_id").in(_idsNew);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		return op.remove(query, entityClass).getN();
	}

	/****
	 * 删除数据，根据ids
	 * 
	 * @param _ids
	 * @return
	 */
	public static int removeByIds(List<String> _ids, String collectionName) {

		List<String> _idsNew = new ArrayList<String>();

		for (String _id : _ids) {
			if (ObjectId.isValid(_id)) {
				_idsNew.add(_id);
			}
		}

		Criteria criteria = Criteria.where("_id").in(_idsNew);
		Query query = new Query(criteria);

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		return op.remove(query, collectionName).getN();
	}

}

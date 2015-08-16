package com.mou.mongodb.base.springdb.op;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
}

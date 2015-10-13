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
 * 鍒犻櫎鏁版嵁鐨勫府鍔╃被
 * 
 * @author NBQ
 *
 */
public class DeleteUtil {

	/****
	 * 鍒犻櫎涓�潯
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
	 * 鍒犻櫎涓�潯
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
	 * 鍒犻櫎鍏ㄩ儴婊¤冻鏉′欢鐨勬暟鎹�
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
	 * 鍒犻櫎鍏ㄩ儴婊¤冻鏉′欢鐨勬暟鎹�
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
	 * 鍒犻櫎涓�潯
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
		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateFirst(query, update, entityClass).getN();

	}

	/****
	 * 鍒犻櫎涓�潯
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
		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateFirst(query, update, collectionName).getN();
	}

	/****
	 * 鍒犻櫎鍏ㄩ儴婊¤冻鏉′欢鐨勬暟鎹�
	 * 
	 * @param _id
	 * @param entityClass
	 * @return
	 */
	public static <T> int removeByConditionLogic(Query query,
			Class<T> entityClass) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateMulti(query, update, entityClass).getN();
	}

	/****
	 * 鍒犻櫎鍏ㄩ儴婊¤冻鏉′欢鐨勬暟鎹�
	 * 
	 * @param _id
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public static int removeByConditionLogic(Query query, String collectionName) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();

		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateMulti(query, update, collectionName).getN();
	}

	/****
	 * 鍒犻櫎鏁版嵁锛屾牴鎹甶ds锛堥�杈戝垹闄わ級
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
		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateMulti(query, update, entityClass).getN();
	}

	/****
	 * 鍒犻櫎鏁版嵁锛屾牴鎹甶ds锛堥�杈戝垹闄わ級
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
		Update update = new Update().set("del_flg", "1").set("del_flg_name",
				"已删除");

		return op.updateMulti(query, update, collectionName).getN();
	}

	/****
	 * 鍒犻櫎鏁版嵁锛屾牴鎹甶ds
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
	 * 鍒犻櫎鏁版嵁锛屾牴鎹甶ds
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

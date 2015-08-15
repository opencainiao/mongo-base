package com.mou.mongodb.base.springdb.db.op;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.springdb.db.MongoTemplateHelper;

public class InsertUtil {

	/****
	 * 插入一个对象
	 * 
	 * @param collectionName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static String insertOne(BaseModel model) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		op.insert(model);

		return model.get_id_m();
	}

	/****
	 * 插入一组对象
	 * 
	 * @param collectionName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static List<String> insertAll(List<? extends BaseModel> models) {

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		op.insertAll(models);

		List<String> ids = new ArrayList<String>();

		for (BaseModel bm : models) {
			ids.add(bm.get_id_m());
		}

		return ids;
	}

}

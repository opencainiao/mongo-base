package com.mou.mongodb.base.springdb.op;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.JsonUtil;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;

public class InsertUtil {
	private static final Logger logger = LogManager.getLogger(FileOp.class);

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

		model.setDel_flg(false);
		op.insert(model);

		logger.debug("inserted-result\n,{}",JsonUtil.getPrettyJsonStr(model));
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

		for (BaseModel model : models) {
			model.setDel_flg(false);
		}

		MongoOperations op = MongoTemplateHelper.getMongoTemplate();
		op.insertAll(models);

		List<String> ids = new ArrayList<String>();

		for (BaseModel bm : models) {
			ids.add(bm.get_id_m());
		}

		return ids;
	}

}

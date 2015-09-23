package com.mou.mongodb.base.springmongo;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mou.common.security.EncryptMou;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mou.mongodb.base.Client;
import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;
import com.mou.mongodb.base.springdb.op.UpdateUtil;
import com.mou.mongodb.base.springmongo.domain.User;
import com.mou.mongodb.base.springmongo.domain.UserCharacter;
import com.mou.mongodb.base.springmongo.domain.UserState;

public class UserManage {

	@Test
	public void test() {

		MongoOperations mongoOps = MongoTemplateHelper.getMongoTemplate();

		User user = new User();
		user.setNick("管理员");
		user.setC_user_name("system");
		user.setUsername("admin");
		// 密码加密
		String newPasswordHashed = EncryptMou.encrypt("admin");
		user.setPassword(newPasswordHashed);
		user.setState(UserState.ACTIVE);
		user.setCharacter(UserCharacter.BOTH_MANAGE_AND_FRONTUSER);

		mongoOps.insert(user);
		
		System.out.println(user);
		
		DBObject upResult = setDelFlg(user.get_id_m());
		
		System.out.println(upResult);
	}
	
	private DBObject setDelFlg(String userid){
		
		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("delflg", "0");
		update.put("$set", updateSet);
		
		DBCollection collection = MongoTemplateHelper
				.getCollection(User.class);

		DBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(userid));

		DBObject upResult = collection.findAndModify(query, null, null, false,
				update, true, false);
		
		return upResult;
	}
	
	@Test
	public void setDelFlg(){
		
		System.out.println(setDelFlg("55f41366b0fa022b8448e661"));
	}

}

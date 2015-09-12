package com.mou.mongodb.base.springmongo;

import org.junit.Test;
import org.mou.common.security.EncryptMou;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mou.mongodb.base.springdb.manage.MongoTemplateHelper;
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
	}

}

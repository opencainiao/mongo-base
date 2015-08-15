package com.mou.mongodb.base;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mou.common.JsonUtil;

import com.mongodb.DBObject;
import com.mou.mongodb.base.db.op.FindOneUtil;

public class FindOneTest {

	@Test
	public void testFindOneByIdDBO() {

		String id = "55cec4087db9c60e4c9f778e";
		try {
			id = "5";
			DBObject dbo = FindOneUtil.findOneDBObjectById("address", id);

			System.out.println(dbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindOneByIdBean() {
		
		try {
			String address_id = "55cec4087db9c60e4c9f778e";
			Address address = FindOneUtil.findOneBeanById("address", address_id, Address.class);
			System.out.println("ADDRESS---\n" + address);
			
			
			String client_id = "55ced0ee7db9c60e30ad4227";
			Client client = FindOneUtil.findOneBeanById("client", client_id, Client.class);
			System.out.println("client---\n" + JsonUtil.getPrettyJsonStr(client));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

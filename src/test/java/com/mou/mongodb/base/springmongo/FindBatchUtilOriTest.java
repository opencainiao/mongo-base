package com.mou.mongodb.base.springmongo;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.mou.common.JsonUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.Address;
import com.mou.mongodb.base.springdb.op.FindBatchUtilOri;
import com.mou.mongodb.base.springmongo.domain.Client;

public class FindBatchUtilOriTest {

	@Test
	public void testFindAllDBObjectDBObjectClassOfT() {

		// 1.单实体对象
		DBObject orderBy = new BasicDBObject();
		orderBy.put("type_value", 1);
		orderBy.put("_id", -1);
		// List<Address> addresses = FindBatchUtilOri.findAll(orderBy,
		// Address.class);
		//
		// for (Address address : addresses) {
		// System.out.print(address.get_id_m() + "----");
		// System.out.println(JsonUtil.toJsonStr(address));
		// }

		// 2.复合实体对象
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		List<Client> clients = FindBatchUtilOri.findAll(orderBy, Client.class);

		for (Client client : clients) {
			System.out.print(client.get_id_m() + "----");
			System.out.println(client.getAddress_info());
			System.out.println(client.getPhone_info());
			// System.out.println(JsonUtil.toJsonStr(client));
		}

	}

	@Test
	public void testFindAllDBObjectDBObjectClassOfTString() {

		// 1.单实体对象
		DBObject orderBy = new BasicDBObject();
		orderBy.put("type_value", 1);
		orderBy.put("_id", -1);
		// List<Address> addresses = FindBatchUtilOri.findAll(orderBy,
		// Address.class);
		//
		// for (Address address : addresses) {
		// System.out.print(address.get_id_m() + "----");
		// System.out.println(JsonUtil.toJsonStr(address));
		// }

		// 2.复合实体对象-类与表不匹配1
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		List<Client> clients = FindBatchUtilOri.findAll(orderBy, Client.class, "aa");

		System.out.println("总条数:" + clients.size());
		for (Client client : clients) {
			System.out.print(client.get_id_m() + "----");
			System.out.println(client.getAddress_info());
			System.out.println(client.getPhone_info());
			// System.out.println(JsonUtil.toJsonStr(client));
		}

		// 2.复合实体对象-类与表不匹配2
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		List<Address> addresses = FindBatchUtilOri.findAll(orderBy, Address.class, "client");

		System.out.println("总条数:" + addresses.size());
		for (Address address : addresses) {
			 System.out.println(JsonUtil.toJsonStr(address));
		}
		
		// 3.复合实体对象-类与表匹配
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		clients = FindBatchUtilOri.findAll(orderBy, Client.class, "client");

		System.out.println("总条数:" + clients.size());
		for (Client client : clients) {
			System.out.print(client.get_id_m() + "----");
			System.out.println(client.getAddress_info());
			System.out.println(client.getPhone_info());
			// System.out.println(JsonUtil.toJsonStr(client));
		}
	}

	@Test
	public void testFindAllDBObjectDBObjectDBObjectClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllDBObjectDBObjectDBObjectClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchDBObjectDBObjectClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchDBObjectDBObjectClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchDBObjectDBObjectDBObjectClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchDBObjectDBObjectDBObjectString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartDBObjectDBObjectDBObjectClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartDBObjectDBObjectDBObjectClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartDBObjectDBObjectDBObjectDBObjectClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartDBObjectDBObjectDBObjectDBObjectString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPageDBObjectDBObjectPageVOClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPageDBObjectDBObjectPageVOClassOfTString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartPageDBObjectDBObjectDBObjectClassOfTPageVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPartPageDBObjectDBObjectDBObjectClassOfTStringPageVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPageDBObjectDBObjectDBObjectPageVOClassOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBatchPageDBObjectDBObjectDBObjectPageVOString() {
		fail("Not yet implemented");
	}

}

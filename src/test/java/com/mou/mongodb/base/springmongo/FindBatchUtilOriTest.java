package com.mou.mongodb.base.springmongo;

import java.util.List;

import org.junit.Test;
import org.mou.common.JsonUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.Address;
import com.mou.mongodb.base.domain.PageVO;
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

		// 1.单实体对象
		DBObject orderBy = new BasicDBObject();
		orderBy.put("type_value", 1);
		orderBy.put("_id", -1);
		List<DBObject> addresses = FindBatchUtilOri.findAllDBObject(orderBy, Address.class);

		for (DBObject address : addresses) {
			System.out.print(address.get("_id").toString() + "----");
			System.out.println(address);
		}

		// 2.复合实体对象
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		List<DBObject> clients = FindBatchUtilOri.findAllDBObject(orderBy, Client.class);

		for (DBObject client : clients) {
			System.out.print(client.get("_id").toString() + "----");
			System.out.println(client.get("address_info"));
			System.out.println(client.get("phone_info"));
			System.out.println(client);
		}
	}

	@Test
	public void testFindAllDBObjectDBObjectDBObjectClassOfTString() {
		// 1.单实体对象
		DBObject orderBy = new BasicDBObject();
		orderBy.put("type_value", 1);
		orderBy.put("_id", -1);
		List<DBObject> addresses = FindBatchUtilOri.findAllDBObject(orderBy, Address.class, "address");

		for (DBObject address : addresses) {
			System.out.print(address.get("_id").toString() + "----");
			System.out.println(address);
		}
		System.out.println("------------------------------------------------");

		// 2.复合实体对象-类与表不匹配1
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		List<DBObject> clients = FindBatchUtilOri.findAllDBObject(orderBy, Client.class, "aa");

		System.out.println("总条数:" + clients.size());
		for (DBObject client : clients) {
			System.out.print(client.get("_id").toString() + "----");
			System.out.println(client.get("address_info"));
			System.out.println(client.get("phone_info"));
			System.out.println(client);
		}
		System.out.println("------------------------------------------------");

		// 2.复合实体对象-类与表不匹配2
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		addresses = FindBatchUtilOri.findAllDBObject(orderBy, Address.class, "client");

		System.out.println("总条数:" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
		}
		System.out.println("------------------------------------------------");
		// 3.复合实体对象-类与表匹配
		orderBy = new BasicDBObject();
		orderBy.put("sex", 1);

		clients = FindBatchUtilOri.findAllDBObject(orderBy, Client.class, "client");

		System.out.println("总条数:" + clients.size());
		for (DBObject client : clients) {
			System.out.print(client.get("_id").toString() + "----");
			System.out.println(client.get("address_info"));
			System.out.println(client.get("phone_info"));
			System.out.println(client);
		}
	}

	@Test
	public void testFindBatchDBObjectDBObjectClassOfT() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);
		List<DBObject> addresses = FindBatchUtilOri.findBatchDBObject(query, orderBy, Address.class);

		for (DBObject address : addresses) {
			System.out.print(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testFindBatchDBObjectDBObjectClassOfTString() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);
		List<DBObject> addresses = FindBatchUtilOri.findBatchDBObject(query, orderBy, "aa");

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.print(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
			System.out.println(address);
		}

		System.out.println("--------------------------------");

		addresses = FindBatchUtilOri.findBatchDBObject(query, orderBy, "address");

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.print(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testfindBatch2() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);
		List<Address> addresses = FindBatchUtilOri.findBatch(Address.class, query, orderBy);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testfindBatch() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);
		List<Address> addresses = FindBatchUtilOri.findBatch(Address.class, "aa", query, orderBy);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		addresses = FindBatchUtilOri.findBatch(Address.class, "address", query, orderBy);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testFindBatchPartDBObjectDBObjectDBObjectClassOfT() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPartDBObject(Address.class, query, orderBy, returnFields);

		try {
			System.out.println("条数" + addresses.size());
			for (DBObject address : addresses) {
				System.out.println(address);
				System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
						+ address.get("city").toString() + "----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testfindBatchPartDBObject() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPartDBObject("aa", query, orderBy, returnFields);

		try {
			System.out.println("条数" + addresses.size());
			for (DBObject address : addresses) {
				System.out.println(address);
				System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
						+ address.get("city").toString() + "----");
			}

			addresses = FindBatchUtilOri.findBatchPartDBObject("address", query, orderBy, returnFields);

			try {
				System.out.println("条数" + addresses.size());
				for (DBObject address : addresses) {
					System.out.println(address);
					System.out.println(address.get("_id").toString() + "----" + address.get("province").toString()
							+ "----" + address.get("city").toString() + "----");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testfindBatchPart2() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		List<Address> addresses = FindBatchUtilOri.findBatchPart(Address.class, query, orderBy, returnFields);

		try {
			System.out.println("条数" + addresses.size());
			for (Address address : addresses) {
				System.out.println(address);
				System.out.println(
						address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			}

			System.out.println("-------------------------------------");
			addresses = FindBatchUtilOri.findBatchPart(Address.class, query, orderBy, null);
			System.out.println("条数" + addresses.size());
			for (Address address : addresses) {
				System.out.println(address);
				System.out.println(
						address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testfindBatchPart() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		List<Address> addresses = FindBatchUtilOri.findBatchPart(Address.class, "aa", query, orderBy, returnFields);

		try {
			System.out.println("条数" + addresses.size());
			for (Address address : addresses) {
				System.out.println(address);
				System.out.println(
						address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			}

			addresses = FindBatchUtilOri.findBatchPart(Address.class, "address", query, orderBy, returnFields);

			System.out.println("条数" + addresses.size());
			for (Address address : addresses) {
				System.out.println(address);
				System.out.println(
						address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			}

			System.out.println("-------------------------------------");
			addresses = FindBatchUtilOri.findBatchPart(Address.class, "address", query, orderBy, null);
			System.out.println("条数" + addresses.size());
			for (Address address : addresses) {
				System.out.println(address);
				System.out.println(
						address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testfindBatchPage2() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<Address> addresses = FindBatchUtilOri.findBatchPage(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, query, orderBy, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testfindBatchPage() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<Address> addresses = FindBatchUtilOri.findBatchPage(Address.class, "aa", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, "address", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, "address", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPage(Address.class, "address", query, orderBy, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}
	}

	@Test
	public void testfindBatchPageDBObject2() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPageDBObject(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPageDBObject(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPageDBObject(Address.class, query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPageDBObject(Address.class, query, orderBy, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}
	}

	@Test
	public void testfindBatchPageDBObject() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPageDBObject("aa", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPageDBObject("address", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPageDBObject("address", query, orderBy, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPageDBObject("address", query, orderBy, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}
	}

	@Test
	public void testfindBatchPartPage2() {

		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<Address> addresses = FindBatchUtilOri.findBatchPartPage(Address.class, query, orderBy, returnFields,
				pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, query, orderBy, returnFields, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

	}

	@Test
	public void testfindBatchPartPage() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<Address> addresses = FindBatchUtilOri.findBatchPartPage(Address.class, "aa", query, orderBy, returnFields,
				pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, "address", query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, "address", query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPartPage(Address.class, "address", query, orderBy, returnFields, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (Address address : addresses) {
			System.out.print(address.get_id_m() + "----" + address.getProvince() + "----" + address.getCity() + "----");
			System.out.println(address);
		}

	}

	// public static <T> List<DBObject> (DBObject query, DBObject orderBy,
	// DBObject returnFields,
	@Test
	public void testfindBatchPartPageDBObject() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPartPageDBObject("aa", query, orderBy, returnFields,
				pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject("address", query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject("address", query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject("address", query, orderBy, returnFields, pageVO);

		System.out.println("全部满足条件条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}
	}

	@Test
	public void testfindBatchPartPageDBObject2() {
		DBObject query = new BasicDBObject();
		query.put("province", 1);

		DBObject orderBy = new BasicDBObject();
		orderBy.put("city", 1);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("city", 1);
		returnFields.put("province", 1);

		PageVO pageVO = new PageVO();
		pageVO.setCurPageNum(1);
		pageVO.setPageCount(2);

		List<DBObject> addresses = FindBatchUtilOri.findBatchPartPageDBObject(Address.class, query, orderBy,
				returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(2);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject(Address.class, query, orderBy, returnFields, pageVO);

		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(3);
		pageVO.setPageCount(2);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject(Address.class, query, orderBy, returnFields, pageVO);
		System.out.println("条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}

		pageVO.setCurPageNum(1);
		pageVO.setPageCount(20);

		addresses = FindBatchUtilOri.findBatchPartPageDBObject(Address.class, query, orderBy, returnFields, pageVO);
		System.out.println("全部满足条件条数：" + addresses.size());
		for (DBObject address : addresses) {
			System.out.println(address);
			System.out.println(address.get("_id").toString() + "----" + address.get("province").toString() + "----"
					+ address.get("city").toString() + "----");
		}
	}
}

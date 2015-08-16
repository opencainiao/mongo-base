package com.mou.mongodb.base;

import java.util.ArrayList;
import java.util.List;

import com.mou.mongodb.base.oridb.op.MongoInsertUtil;

public class InsertTest {
	/****
	 * 地址
	 * 
	 * @param client
	 */
	private static List<Address> createAddress() {

		List<Address> addresses = new ArrayList<Address>();

		Address address = new Address();
		address.setType_value("1");
		address.setType_name("个人");
		address.setProvince(1);
		address.setProvince_name("北京");
		address.setCity(13);
		address.setCity_name("市辖区");
		address.setDistrict(35);
		address.setDistrict_name("东城");
		address.setDetail_address("xx街xx号");

		addresses.add(address);

		address = new Address();
		address.setType_value("2");
		address.setType_name("公司");
		address.setProvince(1);
		address.setProvince_name("北京");
		address.setCity(13);
		address.setCity_name("市辖区");
		address.setDistrict(35);
		address.setDistrict_name("西城");
		address.setDetail_address("xx街xx号");

		addresses.add(address);
		return addresses;
	}

	public static void main(String[] args) {

		List<Address> addresses = createAddress();

		Address address = addresses.get(0);
		String _id;
		try {
			_id = MongoInsertUtil.insertOne("address", address);
			System.out.println(_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

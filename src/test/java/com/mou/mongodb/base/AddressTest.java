package com.mou.mongodb.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AddressTest {

	/****
	 * 地址
	 * 
	 * @param client
	 */
	private List<Address> createAddress() {

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

	@Test
	public void testToString() {
		System.out.println(createAddress());
	}
}

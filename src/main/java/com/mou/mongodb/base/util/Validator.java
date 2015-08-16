package com.mou.mongodb.base.util;

import java.util.HashSet;
import java.util.Set;

import com.mongodb.DBObject;

public class Validator {

	public static void checkReturnFields(DBObject returnFields) throws RuntimeException {

		if (returnFields == null){
			return;
		}
		
		Set<String> include = new HashSet<String>();
		Set<String> exclude = new HashSet<String>();

		Set<String> fieldNames = returnFields.keySet();
		for (String fieldName : fieldNames) {
			Object fieldValue = returnFields.get(fieldName);
			if (fieldValue instanceof Integer) {
				int value = ((Integer) fieldValue).intValue();

				if (fieldName.equals("_id")) {
					continue;
				}

				if (value == 1) {
					include.add(fieldName);
				} else if (value == -1) {
					exclude.add(fieldName);
				}
			}
		}

		if (include.size() > 0 && exclude.size() > 0) {
			throw new RuntimeException("投影里除了_id以外，要么全是1，要么全是-1，请重新设置返回投影");
		}
	}
}

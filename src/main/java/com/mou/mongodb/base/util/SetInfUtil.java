package com.mou.mongodb.base.util;

import java.util.Set;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;

public class SetInfUtil {

	
	public static void setReturnFields(Query query, DBObject returnFields) {
		
		Validator.checkReturnFields(returnFields);
		
		if (returnFields != null) {
			Set<String> fieldNames = returnFields.keySet();
			for (String fieldName : fieldNames) {
				Object fieldValue = returnFields.get(fieldName);
				if (fieldValue instanceof Integer) {
					int value = ((Integer) fieldValue).intValue();
					if (value == 1) {
						query.fields().include(fieldName);
					} else if (value == -1) {
						query.fields().exclude(fieldName);
					}
				}
			}
		}
	}
}

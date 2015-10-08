package com.mou.mongodb.base.util;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class EntityClassUtil {

	/****
	 * 根据Class取对应的collectionName，如果没有设置相应注解，则返回类名的小写
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getCollectionName(Class clazz) {

		String collection = clazz.getSimpleName().toLowerCase();

		Document doc = (Document) clazz.getAnnotation(Document.class);

		if (doc != null) {
			String collectionName = doc.collection();
			if (collectionName != null && !collectionName.trim().equals("")) {
				collection = collectionName;
			}
		}

		return collection;
	}
}

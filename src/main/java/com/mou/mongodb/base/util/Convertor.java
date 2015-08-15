package com.mou.mongodb.base.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.mou.common.JsonUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class Convertor {

	/**
	 * 把实体bean对象转换成DBObject
	 * 
	 * @param bean
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> DBObject bean2DBObject(T bean) throws Exception {
		if (bean == null) {
			return null;
		}
		try {
			DBObject dbObject = new BasicDBObject();
			// 获取对象对应类中的所有属性域
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				// 获取属性名
				String varName = field.getName();
				// 修改访问控制权限
				boolean accessFlag = field.isAccessible();
				if (!accessFlag) {
					field.setAccessible(true);
				}
				Object param;

				param = field.get(bean);

				if (param == null) {
					continue;
				} else if (param instanceof Integer) {// 判断变量的类型
					int value = ((Integer) param).intValue();
					dbObject.put(varName, value);
				} else if (param instanceof String) {
					String value = (String) param;
					dbObject.put(varName, value);
				} else if (param instanceof Double) {
					double value = ((Double) param).doubleValue();
					dbObject.put(varName, value);
				} else if (param instanceof Float) {
					float value = ((Float) param).floatValue();
					dbObject.put(varName, value);
				} else if (param instanceof Long) {
					long value = ((Long) param).longValue();
					dbObject.put(varName, value);
				} else if (param instanceof Boolean) {
					boolean value = ((Boolean) param).booleanValue();
					dbObject.put(varName, value);
				} else if (param instanceof Date) {
					Date value = (Date) param;
					dbObject.put(varName, value);
				} else if (param instanceof List) {

					List<DBObject> objs = new ArrayList<DBObject>();
					for (Object obj : (List) param) {
						objs.add(bean2DBObject(obj));
					}

					dbObject.put(varName, objs);
				} else if (param instanceof Array) {
					List<DBObject> objs = new ArrayList<DBObject>();
					for (Object obj : Arrays.asList(param)) {
						objs.add(bean2DBObject(obj));
					}

					dbObject.put(varName, objs);
				} else if (param instanceof Set) {

					Set<DBObject> objs = new HashSet<DBObject>();
					for (Object obj : (Set) param) {
						objs.add(bean2DBObject(obj));
					}

					dbObject.put(varName, objs);
				} else if (param instanceof Map) {

					Map<String, DBObject> objs = new HashMap<String, DBObject>();

					Set keys = ((Map) param).keySet();

					for (Object key : keys) {
						objs.put((String) key, bean2DBObject(((Map) param).get(key)));
					}

					dbObject.put(varName, objs);
				}
				// 恢复访问控制权限
				field.setAccessible(accessFlag);

			}
			return dbObject;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/**
	 * 把DBObject转换成bean对象
	 * 
	 * @param dbObject
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T> T dbObject2Bean(DBObject dbObject, Class<T> clazz)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		if (dbObject == null) {
			return null;
		}
		return JsonUtil.fromJson(JsonUtil.toJsonStr(dbObject), clazz);
	}
}

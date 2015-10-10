package com.mou.mongodb.base.util;

import java.util.List;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.domain.PageVO;

/****
 * 对分页查询的结果进行封装处理
 * 
 * @author NBQ
 *
 */
public class PageSearchResultUtil {

	private static final int PAGE_COUNT_ONEPAGE = Integer.MAX_VALUE;
	private static final int CUR_PAGE_NUM_ONEPAGE = 1;

	/****
	 * 根据分页信息和数据，组装flexigrid需要的结果
	 * 
	 * @param list
	 * @param curpage
	 * @param pageCount
	 * @param total
	 * @return
	 */
	public static PageVO handleDBObjList(List<DBObject> list, PageVO pageVO) {

		int total = pageVO.getTotal();

		if (list != null) {
			for (DBObject dbobj : list) {
				dbobj.put("_id_m", dbobj.get("_id").toString());
			}
			pageVO.setRows(list);

			if (total == 0 && list.size() > 0) {
				pageVO.setTotal(list.size());
			}
		}

		return pageVO;
	}

	/****
	 * 根据数据，组装flexigrid需要的结果（无分页的情况）
	 * 
	 * @param list
	 * @param curpage
	 * @param pageCount
	 * @param total
	 * @return
	 */
	public static PageVO handleDBObjListOnePage(List<DBObject> list, PageVO pageVO) {

		handleDBObjList(list);

		pageVO.setPage(CUR_PAGE_NUM_ONEPAGE);
		pageVO.setPageCount(PAGE_COUNT_ONEPAGE);

		if (list != null) {

			pageVO.setPageCount(list.size());
			pageVO.setTotal(list.size());

			for (DBObject dbobj : list) {
				dbobj.put("_id_m", dbobj.get("_id").toString());
			}
			pageVO.setRows(list);
		}

		return pageVO;
	}

	/****
	 * 设置_id_m的字符串属性
	 * 
	 * @param list
	 */
	private static List<DBObject> handleDBObjList(List<DBObject> list) {

		if (list != null) {
			for (DBObject dbobj : list) {
				dbobj.put("_id_m", dbobj.get("_id").toString());
			}
		}

		return list;
	}

	public static <T extends BaseModel> PageVO handleBaseModelListOnePage(List<T> list, PageVO pageVO) {

		pageVO.setPage(CUR_PAGE_NUM_ONEPAGE);
		pageVO.setPageCount(PAGE_COUNT_ONEPAGE);

		if (list != null) {

			pageVO.setPageCount(list.size());
			pageVO.setTotal(list.size());

			for (BaseModel model : list) {
				model.set_id_m(model.get_id().toString());
				;
			}

			pageVO.setRows(list);
		}

		return pageVO;
	}

	/****
	 * 根据分页信息和数据，组装flexigrid需要的结果
	 * 
	 * @param list
	 * @param curpage
	 * @param pageCount
	 * @param total
	 * @return
	 */
	public static <T extends BaseModel> PageVO handleBaseModelList(List<T> list, PageVO pageVO) {

		int total = pageVO.getTotal();

		if (list != null) {

			for (BaseModel model : list) {
				model.set_id_m(model.get_id().toString());
			}
			
			pageVO.setRows(list);

			if (total <= 0 && list.size() > 0) {
				pageVO.setTotal(list.size());
			}
		}

		return pageVO;
	}

}

package com.mou.mongodb.base.domain;

import org.bson.types.ObjectId;
import org.mou.common.JsonUtil;

/****
 * 基于mongodb的基本对象域模型
 * 
 * @author NBQ
 *
 */
public class BaseModel {

	protected ObjectId _id;
	protected String _id_m; // _id的字符串表示
	protected String c_date; // 创建日期
	protected String c_time; // 创建时间
	protected String c_user_id; // 创建用户id
	protected String c_user_name;// 创建用户姓名
	protected String last_op_user_id;// 最后编辑用户id
	protected String last_op_user_name;// 最后编辑用户姓名
	protected String last_op_date; // 最后操作日期
	protected String last_op_time; // 最后一次操作时间
	protected String del_flg; // 删除标志(用于逻辑删除) 1-已删除
	protected String del_flg_name; // 删除标志名称 0-未删除

	public String get_id_m() {
		if (this.get_id() == null) {
			return null;
		}
		return get_id().toString();
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getLast_op_user_id() {
		return last_op_user_id;
	}

	public void setLast_op_user_id(String last_op_user_id) {
		this.last_op_user_id = last_op_user_id;
	}

	public String getLast_op_user_name() {
		return last_op_user_name;
	}

	public void setLast_op_user_name(String last_op_user_name) {
		this.last_op_user_name = last_op_user_name;
	}

	public String getLast_op_date() {
		return last_op_date;
	}

	public void setLast_op_date(String last_op_date) {
		this.last_op_date = last_op_date;
	}

	public String getLast_op_time() {
		return last_op_time;
	}

	public void setLast_op_time(String last_op_time) {
		this.last_op_time = last_op_time;
	}

	public String getC_user_id() {
		return c_user_id;
	}

	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}

	public String getC_user_name() {
		return c_user_name;
	}

	public void setC_user_name(String c_user_name) {
		this.c_user_name = c_user_name;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getDel_flg_name() {
		return del_flg_name;
	}

	public void setDel_flg_name(String del_flg_name) {
		this.del_flg_name = del_flg_name;
	}

	public void setDel_flg(boolean delflg) {
		if (delflg) {
			this.del_flg = "1";
			this.setDel_flg_name("已删除");
		} else {
			this.del_flg = "0";
			this.setDel_flg_name("正常");
		}
	}

	public void set_id_m(String _id_m) {
		this._id_m = _id_m;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	@Override
	public String toString() {

		return JsonUtil.toJsonStr(this);

	}

}
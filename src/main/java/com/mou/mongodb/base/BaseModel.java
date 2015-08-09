package com.mou.mongodb.base;

import com.mongodb.ReflectionDBObject;
import com.mongodb.util.JSON;

/****
 * 基于mongodb的基本对象域模型
 * 
 * @author NBQ
 *
 */
public class BaseModel extends ReflectionDBObject {

	protected String _id_m; // _id的字符串表示
	protected String c_date; // 创建日期
	protected String c_time; // 创建时间
	protected String c_userid; // 创建用户id
	protected String c_username;// 创建用户姓名
	protected String last_op_user_id;// 最后编辑用户id
	protected String last_op_user_name;// 最后编辑用户姓名
	protected String last_op_date; // 最后操作日期
	protected String last_op_time; // 最后一次操作时间
	protected String delflg; // 删除标志(用于逻辑删除) 1-已删除
	protected String delflg_name; // 删除标志名称 0-未删除

	public String get_id_m() {
		if (super.get_id() == null) {
			return null;
		}
		return super.get_id().toString();
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

	public String getC_userid() {
		return c_userid;
	}

	public void setC_userid(String c_userid) {
		this.c_userid = c_userid;
	}

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
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

	public String getDelflg() {
		return delflg;
	}

	public void setDelflg(boolean delflg) {
		if (delflg) {
			this.delflg = "1";
			this.setDelflg_name("已删除");
		} else {
			this.delflg = "0";
			this.setDelflg_name("正常");
		}
	}

	public void set_id_m(String _id_m) {
		this._id_m = _id_m;
	}

	public String getDelflg_name() {
		return delflg_name;
	}

	private void setDelflg_name(String delflg_name) {
		this.delflg_name = delflg_name;
	}

	@Override
	public String toString() {

		return JSON.serialize(this);
	}

}
package com.mou.mongodb.base;

/****
 * 带有启用标识的对象基类
 * 
 * @author NBQ
 *
 */
public class BaseModelWithUseFlg extends BaseModel {

	protected String use_flg; // 启用标志 1-启用 0-停用

	protected String use_flg_name; // 启用标志名称

	public String getUse_flg() {
		return use_flg;
	}

	public String getUse_flg_name() {
		return use_flg_name;
	}

	public void setUse_flg_name(String use_flg_name) {
		this.use_flg_name = use_flg_name;
	}

	/****
	 * 设置是否启用
	 * 
	 * @param useflg
	 *            true-启用 false-停用
	 */
	public void setUse_flg(boolean use_flg) {
		if (use_flg) {
			this.use_flg = "1";
			this.setUse_flg_name("启用");
		} else {
			this.use_flg = "0";
			this.setUse_flg_name("停用");
		}
	}

}

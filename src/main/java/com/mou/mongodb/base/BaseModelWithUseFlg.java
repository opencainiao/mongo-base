package com.mou.mongodb.base;

/****
 * 带有启用标识的对象基类
 * 
 * @author NBQ
 *
 */
public class BaseModelWithUseFlg extends BaseModel {

	protected String useflg; // 启用标志 1-启用 0-停用
	protected String useflg_name; // 启用标志名称

	public String getUseflg() {
		return useflg;
	}

	/****
	 * 设置是否启用
	 * 
	 * @param useflg
	 *            true-启用 false-停用
	 */
	public void setUseflg(boolean useflg) {
		if (useflg) {
			this.useflg = "1";
			this.setUseflg_name("启用");
		} else {
			this.useflg = "0";
			this.setUseflg_name("停用");
		}
	}

	public String getUseflg_name() {
		return useflg_name;
	}

	private void setUseflg_name(String useflg_name) {
		this.useflg_name = useflg_name;
	}

}

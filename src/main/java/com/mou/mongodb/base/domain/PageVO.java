package com.mou.mongodb.base.domain;

import java.util.List;

import org.mou.common.JsonUtil;

@SuppressWarnings("rawtypes")
public class PageVO {

	private int curPageNum; // 当前页
	private int pageCount; // 每页数据条数

	private int startOffset; // 开始条数
	private int totalNum; // 所有数据条数
	private int totalPage; // 所有页数

	private List rows; // 所有查询结果
	private boolean needCalTotal; // 是否需要计算总数据

	public PageVO() {
		curPageNum = 0;
		pageCount = 10;
		needCalTotal = false;
		pageCount = Integer.MAX_VALUE;
	}

	/****
	 * 根据总数，计算共有多少页
	 */
	public void calMaxPage() {
		totalPage = totalNum / pageCount;

		if (totalNum % pageCount != 0) {
			totalPage += 1;
		}
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartOffset() {

		if (curPageNum == 0) {
			curPageNum = 1;
		}
		startOffset = (curPageNum - 1) * pageCount;

		return startOffset;
	}

	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public boolean isNeedCalTotal() {
		return needCalTotal;
	}

	public void setNeedCalTotal(boolean needCalTotal) {
		this.needCalTotal = needCalTotal;
	}

	public String toString() {

		return JsonUtil.getPrettyJsonStr(this);
	}
}

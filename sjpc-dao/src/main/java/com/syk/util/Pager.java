package com.syk.util;

import java.util.List;

/**
 * 分页对象
 */
public class Pager<T> {

	public static final Integer DISPLAY_LENGTH = 15;
	public static final Integer DISPLAY_START = 0;

	/**
	 * 分页的大小
	 */
	private Integer iDisplayLength;
	
	private Object rows;
	private Integer page;
	private Integer records;
	private Long total;

	/**
	 * 分页的起始页
	 */
	private Integer iDisplayStart;

	/**
	 * 总记录数
	 */
	private Long iTotalRecords;

	/**
	 * 总记录数
	 */
	private Long iTotalDisplayRecords;

	/**
	 * 
	 */
	private List<T> aaData;

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		setiTotalDisplayRecords(iTotalRecords);
		total = iTotalRecords;
		this.iTotalRecords = iTotalRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		rows = aaData;
		records = aaData.size();
		this.aaData = aaData;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		iDisplayStart = (page-1)*(iDisplayStart==null?0:iDisplayStart);
		this.page = page;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		iDisplayLength = Integer.valueOf(rows.toString());
		iDisplayStart = (page-1)*(iDisplayStart==null?0:iDisplayStart);
		this.rows = rows;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	

}

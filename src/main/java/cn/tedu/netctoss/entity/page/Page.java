package cn.tedu.netctoss.entity.page;
/**
 * 用于分页
 * @author soft01
 *
 */
public abstract class Page {
//	private int currentPage = 1;//当前页
	private int page = 1;
	private int pageSize = 5;//每夜显示最大行数
	private int begin;//当前页的起始行
	private int end;//当前页的终止行
	private int rows;//总行数
	private int totalPage;//总页数
//	public int getBegin() {
//		begin = (currentPage-1)*pageSize;
//		return begin;
//	}
//	public int getEnd() {
//		end = currentPage*pageSize+1;
//		return end;
//	}
	public int getBegin() {
		begin = (page-1)*pageSize;
		return begin;
	}
	public int getEnd() {
		end = page*pageSize+1;
		return end;
	}
	public int getTotalPage() {
		if(rows%pageSize == 0) {
			totalPage = rows/pageSize;
		}else {
			totalPage = rows/pageSize+1;
		}
		return totalPage;
	}
//	public int getCurrentPage() {
//		return currentPage;
//	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage =currentPage;
//	}
	
	public int getPageSize() {
		return pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
}

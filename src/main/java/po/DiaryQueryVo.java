package po;

import java.util.List;

/**
 * 查询包装类
 * @author 19218
 *
 */
public class DiaryQueryVo {
	// 一共多少条记录
	private Integer totalRecord; 
	// 根据 title 查询
	private  Diary diary;
	// 查询结果列表
	private List<Diary> diaryList;
	//当前第几页
	private Integer currentPageNum;
	// 共多少页
	private Integer pageSum;
	// 查询下标
	private Integer pageIndex;
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	public List<Diary> getDiaryList() {
		return diaryList;
	}
	public void setDiaryList(List<Diary> diaryList) {
		this.diaryList = diaryList;
	}

}

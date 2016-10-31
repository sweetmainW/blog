package service;

import java.util.List;

import po.Diary;
import po.DiaryQueryVo;

public interface DiaryQueryService {
	/**
	 * 根据查询条件，分页查询日记信息
	 * @param diaryQueryVo 封装查询条件
	 * @return 查询结果
	 */
	public List<Diary> findDairy(DiaryQueryVo diaryQueryVo) throws Exception;
	
	/**
	 * 查询一共有多少条记录
	 * @param diaryQueryVo 封装查询条件
	 * @return 总记录数
	 */
	public Integer totalRecord(DiaryQueryVo diaryQueryVo) throws Exception;
}

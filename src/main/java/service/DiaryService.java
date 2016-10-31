package service;

import java.util.List;

import po.Diary;


public interface DiaryService {
	// 根据 title 标题查询 日记
	public List<Diary> selectByTitle(Diary diary) throws Exception;
	// 根据 uid 查询日记
	public List<Diary> selectByUid(Integer uid) throws Exception;
	// 新建日记， 必须参数 title,uid 
	public void insertDiary(Diary diary) throws Exception;
	// 根据 lid主键 查询日记
	public Diary selectByPrimaryKey(Integer lid) throws Exception;
	// 根据 lid主键更新 日记
	public void updateDiary(Diary diary) throws Exception;
	// 删除 lid 日记
	public void deleteByPrimaryKey(Integer lid) throws Exception;
}

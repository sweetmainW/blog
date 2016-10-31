package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.DiaryMapper;
import po.Diary;
import service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {
	// 注入 diaryMapper
	@Autowired
	private DiaryMapper diaryMapper;
	
	/**
	 * 根据 title 查询日记列表，为null时查询所有
	 * @param diary 要查询的信息
	 * @return 返回查询到的日记列表
	 */
	public List<Diary> selectByTitle(Diary diary) throws Exception{
		// 调用 mapper层方法查询 
		List<Diary>  diaryList = diaryMapper.selectByTitle(diary);
		return diaryList;
	}

	/**
	 * 根据 uid 外键进行查询
	 * @param uid 外键的值（用户uid）
	 * @return 返回查询到的日记列表
	 */
	public List<Diary> selectByUid(Integer uid) throws Exception {
		// 调用 mapper层方法查询 
		List<Diary> diaryList = diaryMapper.selectByUid(uid);
		return diaryList;
	}

	/**
	 * 添加新的日记
	 * @param diary 要添加日记的信息
	 * @exception
	 */
	public void insertDiary(Diary diary) throws Exception {
		// 调用 mapper层方法插入日记
		diaryMapper.insertDiary(diary);
	}

	/**
	 * 根据主键查询日记
	 * @param 要查询日记的 主键 lid
	 * @return 查询到的日记对象
	 * @exception
	 */
	public Diary selectByPrimaryKey(Integer lid) throws Exception {
		return diaryMapper.selectByPrimaryKey(lid);
	}

	/**
	 * 根据 主键更新日记
	 * @param 要更新的日记对象
	 * @exception 
	 */
	public void updateDiary(Diary diary) throws Exception {
		diaryMapper.updateDiary(diary);
	}

	/**
	 * 根据 主键删除日记
	 * @param 主键的值
	 * @exception 
	 */
	public void deleteByPrimaryKey(Integer lid) throws Exception {
		diaryMapper.deleteByPrimaryKey(lid);
	}
	
	
	
	

}

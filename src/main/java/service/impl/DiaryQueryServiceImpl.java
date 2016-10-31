package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.DiaryQueryVoMapper;
import po.Diary;
import po.DiaryQueryVo;
import service.DiaryQueryService;

@Service
public class DiaryQueryServiceImpl implements DiaryQueryService{
	@Autowired
	private DiaryQueryVoMapper diaryQueryVoMapper;

	/**
	 * 根据查询条件，分页查询日记信息
	 * @param diaryQueryVo 封装查询条件 (diary.uid, diary.title, pageIndex)
	 * @return 查询结果
	 */
	public List<Diary> findDairy(DiaryQueryVo diaryQueryVo) throws Exception {
		return diaryQueryVoMapper.findDairy(diaryQueryVo);
	}

	/**
	 * 查询一共有多少条记录
	 * @param diaryQueryVo 封装查询条件 (diary.uid, diary.title)
	 * @return 总记录数
	 */
	public Integer totalRecord(DiaryQueryVo diaryQueryVo) throws Exception {
		return diaryQueryVoMapper.totalRecord(diaryQueryVo);
	}

}

package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.Diary;

public interface DiaryMapper {
	// 插入日记
	void insertDiary(Diary diary);
	// 根据 lid 主键查找 日记
	Diary selectByPrimaryKey(@Param(value = "lid") Integer lid);
	// 根据 标题查询 日记
	List<Diary> selectByTitle(Diary diary);
	// 根据 uid 查询日记
	List<Diary> selectByUid (@Param(value = "uid") Integer uid);
	// 更新日记
	void updateDiary(Diary diary);
	// 删除 lid 日记
	void deleteByPrimaryKey(@Param(value = "lid") Integer lid);
}

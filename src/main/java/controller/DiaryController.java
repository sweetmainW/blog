package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.Diary;
import po.DiaryQueryVo;
import po.User;
import service.DiaryQueryService;
import service.DiaryService;
import service.UserService;

@Controller
public class DiaryController {
	// 注入 Service
	@Autowired
	private DiaryService diaryService;
	@Autowired
	private UserService userService;
	@Autowired
	private DiaryQueryService diaryQueryService;
	
	/**
	 * 用户访问 xxx/diaryList.action时会跳到这里
	 * @param session 保存登录的用户名
	 * @param diary  日记对象
	 * @param titleSearch 提交过来的搜索内容
	 * @return 返回包含 日记列表数据和页面
	 * @throws Exception
	 */
	@RequestMapping("diaryList")
	public ModelAndView diaryList (HttpSession session, HttpServletRequest request, 
			DiaryQueryVo diaryQueryVo, Diary diary, String titleSearch ) throws Exception {
		ModelAndView mv = new ModelAndView();
		//从session中取得保存的uname用户名
		String uname = (String)session.getAttribute("uname");
		// 根据用户名，调用service 查询用户的详细信息
		User user = userService.selectByName(uname);
		//设置 uid
		if (diary != null){
			diary.setUid(user.getUid());
		}
		if (titleSearch == null ){
			// 把title 设置为空， 进行全部查询
			diary.setTitle(null);
		}
		// 设置要模糊查询的标题内容 title
		diary.setTitle(titleSearch);
		// 设置日记对象的 uid
		diary.setUid(user.getUid());
		
		// 设置日记对象
		diaryQueryVo.setDiary(diary);
		// 先获取总记录数
		Integer totalRecord = diaryQueryService.totalRecord(diaryQueryVo);
		// 设置总记录数
		diaryQueryVo.setTotalRecord(totalRecord);
		
		// 获取一共多少页
		Integer pageSum = totalRecord/5;
		if (totalRecord % 5 != 0){
			pageSum++; // 如果不能整除，则加1
		}
		// 设置总 页数
		diaryQueryVo.setPageSum(pageSum);
		
		// 如果 当前页 为空
		if (diaryQueryVo.getCurrentPageNum() == null ){
			//默认设置第 一页
			diaryQueryVo.setCurrentPageNum(1);
			// 设置分页下标
			diaryQueryVo.setPageIndex((diaryQueryVo.getCurrentPageNum() - 1) * 5);
		}else {
			// 如果 pageNum 参数 超过最大记录数, 那么返回错误信息
			if (((diaryQueryVo.getCurrentPageNum() - 1) * 5) > diaryQueryVo.getTotalRecord()) {
				request.setAttribute("errorMsg", "参数传输错误");
				return mv;
			}else {
				// 设置分页下标
				diaryQueryVo.setPageIndex((diaryQueryVo.getCurrentPageNum() - 1) * 5);
			}
		}
		
		// 查询数据
		List<Diary> diaryList = diaryQueryService.findDairy(diaryQueryVo);
		// 设置数据
		diaryQueryVo.setDiaryList(diaryList);
		
		mv.addObject("diaryQueryVo", diaryQueryVo);
		mv.addObject("user", user);
		mv.setViewName("diaryList");
		
		return mv;
	}
	/**
	 * 用户点击新建日记时，会到达这里
	 * @param session 里面包含 登录的user用户详细信息
	 * @return 返回 一个 新建日记的视图
	 * @throws Exception
	 */
	@RequestMapping("newDiary")
	public String newDiary(HttpSession session, Model model)  throws Exception{
		// 从session中取出保存的用户信息
		String uname  = (String)session.getAttribute("uname");
		// 根据用户名查询出用户的详细信息
		User user = userService.selectByName(uname);
		// 保存进 model
		model.addAttribute("user", user);
		return "newDiary";
	}
	
	/**
	 * 点击创建日记会跳转到此处
	 * @param diary 用户填写的日记信息
	 * @return 转发到日记列表页面
	 * @throws Exception
	 */
	@RequestMapping("insert")
	public String insert(HttpSession session, Diary diary)  throws Exception {
		diaryService.insertDiary(diary);
		session.setAttribute("uid", diary.getUid());
		// 转发到 diaryList页面
		return "forward:diaryList.action";
	}
	
	/**
	 * 用户点击修改会跳到此处
	 * @param diary
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("showDiary")
	public ModelAndView showDiary (Diary diary) throws Exception {
		// 根据 lid 查询日记对象
		diary = diaryService.selectByPrimaryKey(diary.getLid());
		ModelAndView mv = new ModelAndView();
		// 保存进 mv
		mv.addObject("diary", diary);
		// 跳转到 showDiary页面
		mv.setViewName("showDiary");
		return mv;
	}
	/**
	 * 用户点击提交修改会到达这个方法
	 * @param session 
	 * @param diary 用户更新后的日记对象
	 * @return 返回到 日记列表页面
	 * @throws Exception
	 */
	@RequestMapping("update")
	public String update(Diary diary) throws Exception {
		// 调用service 层方法进行更新
		diaryService.updateDiary(diary);
		return "forward:diaryList.action";
	}
	
	/**
	 * 用户点击删除会到达此方法
	 * @param diary 用户要删除的对象(lid)
	 * @return 返回到 日记列表页面
	 * @throws Exception
	 */
	@RequestMapping ("delete")
	public String delete(Diary diary) throws Exception {
		diaryService.deleteByPrimaryKey(diary.getLid());
		return "forward:diaryList.action";
	}
}

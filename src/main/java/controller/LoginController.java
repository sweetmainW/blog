package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Diary;
import po.DiaryQueryVo;
import po.User;
import service.DiaryQueryService;
import service.DiaryService;
import service.UserService;

@Controller
public class LoginController {
	
	// 注入 service
	@Autowired
	private UserService userService;
	@Autowired
	private DiaryService diaryService;
	@Autowired
	private DiaryQueryService diaryQueryService;
	/**
	 * 用户登录时访问此处
	 * @param session
	 * @param user 用户登录信息
	 * @param model 模型数据，包含该用户的日记列表对象
	 * @return 跳转到日记列表页面
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpSession session, HttpServletRequest request, User user, Model model,
			DiaryQueryVo diaryQueryVo, Diary diary) throws Exception {
		// 如果 session中没有 uname 的值，说明是第一次访问，放行到 login.jsp页面，再次提交时，调用service查询，然后保存用户信息，
		String uname = (String) session.getAttribute("uname");
		if (uname == null && user.getUname() == null){
			return "forward:WEB-INF/jsp/login.jsp";
		}
		
		if (user != null) {
			// 把用户名保存进session
			session.setAttribute("uname", user.getUname());
			// 根据用户名查询出用户的详细信息，再赋给 user
			user = userService.selectByName(user.getUname());
			// 设置 日记对象的uid 
			diary.setUid(user.getUid());
			// --分页开始--
			// 设置 日记对象
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
			}
			
			// 查询数据
			List<Diary> diaryList = diaryQueryService.findDairy(diaryQueryVo);
			// 设置数据
			diaryQueryVo.setDiaryList(diaryList);
			// --分页结束--
			// 把查询到的 该用户的日记列表保存进 model
			model.addAttribute("diaryQueryVo", diaryQueryVo);
			// 转发到 diaryList.action
			return "diaryList";
		}
		// 根据session中取得的uname，说明用户已经登录了，查找 用户的详细信息返回给日记列表页面
		user = userService.selectByName(uname);
		session.setAttribute("uname", user.getUname());
		return "forward:diaryList.action";
	}
	
	/**
	 * 用户点击退出会访问这里
	 * @param session 保存用户信息
	 * @return 重定向到登录页面
	 * @throws Exception
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session中保存的数据
		session.invalidate();
		// 返回到登录页面
		return "redirect:login.action";
	}
	
	/**
	 * ajax校验用户名和密码
	 * @param user 用户提交的信息
	 * @return 从数据库中查询到的用户对象
	 * @throws Exception
	 */
	@RequestMapping("ajaxValidate")
	public @ResponseBody User ajaxValidate(@RequestBody User user) throws Exception {
		// 获得用户提交的用户名
		String uname = user.getUname();
		// 调用Service层方法查询此用户的详细信息
		user = userService.selectByName(uname);
		if (user != null ) {
			user.setPassword("");
		}
		return user;
	}
	
	@RequestMapping("register")
	public String register(HttpSession session, User user, Model model) throws Exception {
		// 把用户名保存进session
		session.setAttribute("uname", user.getUname());
		// 创建 用户
		userService.insertUser(user);
		// 根据姓名查找到该用户，然后重新赋值给 user ，此时 uid已经有了
		user = userService.selectByName(user.getUname());
		// 然后再根据用户 uid 查询 所属的日记列表
		List<Diary> diaryList = diaryService.selectByUid(user.getUid());
		// 把查询到的 该用户的日记列表保存进 model
		model.addAttribute("diaryList", diaryList);
		// 转发到 diaryList.action
		return "diaryList";
	}
	
}

package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

		
	//进入 Handler方法之前执行
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//获取请求的url
		String url = request.getRequestURI();
		
		// 如果是 注册请求，放行
		if (url.indexOf("register.action") >= 0) {
			return true;
		}
		
		// 如果是ajax请求，放行
		if (url.indexOf("ajaxValidate.action") >= 0) {
			return true;
		}
		// 判断是否请求的是 登录页面
		if(url.indexOf("login.action")>=0){
			//如果是，放行
			return true;
		}
		
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		String uname = (String) session.getAttribute("uname");
		
		if(uname != null){
			//身份存在，放行
			return true;
		}
		
		//执行这里表示用户身份需要认证，不放行并跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("返回视图之前执行");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("执行完Handler");
	}

}

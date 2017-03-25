package mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.ActionForward;
import mvc.controller.SuperAction;

public class MvcTestAction implements SuperAction{

	
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 한글깨짐을 막기위한 인코딩.
		request.setCharacterEncoding("utf-8");
		
		// 파라미터를 받아옵니다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// 파라미터를 넘겨줍니다.
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("name", name);
		
		String path = "/formPro.jsp";
		ActionForward aforward = new ActionForward(path);
				 
		return aforward;
	}

}

package mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.ActionForward;
import mvc.controller.SuperAction;

public class MvcTestAction implements SuperAction{

	
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// �ѱ۱����� �������� ���ڵ�.
		request.setCharacterEncoding("utf-8");
		
		// �Ķ���͸� �޾ƿɴϴ�.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// �Ķ���͸� �Ѱ��ݴϴ�.
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("name", name);
		
		String path = "/formPro.jsp";
		ActionForward aforward = new ActionForward(path);
				 
		return aforward;
	}

}

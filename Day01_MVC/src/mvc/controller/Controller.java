package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.action.MvcTestAction;



public class Controller extends HttpServlet{	
	
	public void init(ServletConfig config) throws ServletException {		
		System.out.println("init");
	}	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get");
		requestPro(req, resp);		
	}	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post");
		requestPro(req, resp);		
	}
	protected void requestPro(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 요청 URI 읽어오기
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		// ContextPath 읽어오기
		String conPath = req.getContextPath();
		System.out.println("conPath : "+conPath);
		
		// 액션명 추출하기
		String path = uri.substring(conPath.length(), uri.length()-3);
		System.out.println(path);
		
		UserActionFactory uaf = UserActionFactory.getInstance();
		
		SuperAction action = uaf.getAction(path);
		
		// 페이지 이동방식 redirect or forward 결정 
		ActionForward aforward = null;
		try {
			aforward = action.execute(req, resp);
		} catch (Exception e) {e.printStackTrace();}
		
		if(aforward.isRedirect()){
			// Redirect로 이동한다.
			resp.sendRedirect(conPath+aforward.getPath());
		}else {	
			// Forward로 이동한다.
						// 서블릿에서 Forward로 이동하는 방법
						// 메소드에 이동할 경로를 전달할 때 ContextName은 생략해야 한다.
			RequestDispatcher rd = req.getRequestDispatcher(aforward.getPath());
			rd.forward(req, resp);
		}
		
	}
}

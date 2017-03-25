package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.action.SuperAction;

public class Controller extends HttpServlet{	
	
	// 요청시 가장 먼저 실행된다.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	
	// get방식으로 요청시 실행된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		requestPro(request, response);
		
	}
	
	// post방식으로 요청시 실행된다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		requestPro(request, response);		
	}
	
	// get-post상관없이 실행하는 메소드.
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 요청 uri 값을 받아온다.		
		String uri  = request.getRequestURI();	// /D1_MVC/test.do
		System.out.println("uri : "+uri);
		
		// ContextPath 값을 받아온다.
		String conPath = request.getContextPath(); // /D1_MVC
		System.out.println("conPath : "+conPath);
		
		
		// ContextPath 와 .do를 제외한 path값.
		String path = uri.substring(conPath.length(), uri.length() - 3);	// /test
		System.out.println("path : " + path);
		
		// path 값을 구분지어 요청할  ActionFactory를 통해 Action객체를 생성한다.
		SuperAction action = ActionFactory.getInstance(path);
		
		
		
		ActionForward aForward = null;
		try {
			// 액션 excute 호출후 이동할 경로를 리턴 받는다.
			aForward = action.excute(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(aForward.isRedirect()){
			// redirect방식으로 이동
			response.sendRedirect(conPath + aForward.getView());	// /D1_MVC/result.jsp		
		}else{
			// foward방식으로 이동.
			RequestDispatcher rd = request.getRequestDispatcher(aForward.getView());	// /result.jsp
			rd.forward(request, response);			
		}
		
		
		
		
	}
}

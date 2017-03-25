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
	
	// ��û�� ���� ���� ����ȴ�.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	
	// get������� ��û�� ����ȴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		requestPro(request, response);
		
	}
	
	// post������� ��û�� ����ȴ�.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		requestPro(request, response);		
	}
	
	// get-post������� �����ϴ� �޼ҵ�.
	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ��û uri ���� �޾ƿ´�.		
		String uri  = request.getRequestURI();	// /D1_MVC/test.do
		System.out.println("uri : "+uri);
		
		// ContextPath ���� �޾ƿ´�.
		String conPath = request.getContextPath(); // /D1_MVC
		System.out.println("conPath : "+conPath);
		
		
		// ContextPath �� .do�� ������ path��.
		String path = uri.substring(conPath.length(), uri.length() - 3);	// /test
		System.out.println("path : " + path);
		
		// path ���� �������� ��û��  ActionFactory�� ���� Action��ü�� �����Ѵ�.
		SuperAction action = ActionFactory.getInstance(path);
		
		
		
		ActionForward aForward = null;
		try {
			// �׼� excute ȣ���� �̵��� ��θ� ���� �޴´�.
			aForward = action.excute(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(aForward.isRedirect()){
			// redirect������� �̵�
			response.sendRedirect(conPath + aForward.getView());	// /D1_MVC/result.jsp		
		}else{
			// foward������� �̵�.
			RequestDispatcher rd = request.getRequestDispatcher(aForward.getView());	// /result.jsp
			rd.forward(request, response);			
		}
		
		
		
		
	}
}

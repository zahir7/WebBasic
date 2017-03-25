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
		
		// ��û URI �о����
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		// ContextPath �о����
		String conPath = req.getContextPath();
		System.out.println("conPath : "+conPath);
		
		// �׼Ǹ� �����ϱ�
		String path = uri.substring(conPath.length(), uri.length()-3);
		System.out.println(path);
		
		UserActionFactory uaf = UserActionFactory.getInstance();
		
		SuperAction action = uaf.getAction(path);
		
		// ������ �̵���� redirect or forward ���� 
		ActionForward aforward = null;
		try {
			aforward = action.execute(req, resp);
		} catch (Exception e) {e.printStackTrace();}
		
		if(aforward.isRedirect()){
			// Redirect�� �̵��Ѵ�.
			resp.sendRedirect(conPath+aforward.getPath());
		}else {	
			// Forward�� �̵��Ѵ�.
						// �������� Forward�� �̵��ϴ� ���
						// �޼ҵ忡 �̵��� ��θ� ������ �� ContextName�� �����ؾ� �Ѵ�.
			RequestDispatcher rd = req.getRequestDispatcher(aforward.getPath());
			rd.forward(req, resp);
		}
		
	}
}

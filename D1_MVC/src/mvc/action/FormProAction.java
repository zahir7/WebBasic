package mvc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.ActionForward;
import mvc.model.DAO;
import mvc.model.DTO;

public class FormProAction implements SuperAction{

	@Override
	public ActionForward excute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		
		
		
		
		// 한글 깨짐을 막기위한 인코딩
		request.setCharacterEncoding("euc-kr");
		
		// 파라미터 값 받아오기.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		
		DTO dto = new DTO(id, pw, name);
		DAO dao = DAO.getInstance();
		
		List mlist = new ArrayList();
		
		boolean isSuccess = dao.insert(dto);
		System.out.println(isSuccess);
		
		mlist = dao.select();
		// 파라미터 넘겨주기.
		request.setAttribute("mlist", mlist);		// 파라미터 넘겨준다.	
		ActionForward aForward =  new ActionForward("/result.jsp");
		
		return aForward;
	}

	


}

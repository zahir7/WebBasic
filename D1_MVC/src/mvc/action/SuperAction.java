package mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.ActionForward;

public interface SuperAction {
	
	public abstract ActionForward excute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}

package mvc.controller;

import mvc.action.FormProAction;
import mvc.action.SuperAction;

public class ActionFactory {
	
	// 싱글톤 방식으로 사용하기위한 변수 선언
	private static ActionFactory af;

	// 외부에서 객체 생성을 막기위해 접근제한자를 private으로 한다.
	private ActionFactory(){}
	
	public static SuperAction getInstance(String path){
		
		SuperAction action = null;
		
		// path값 구분지어 해당액션 객체 생성
		if(path.equals("/mvcTest")){
			action = new FormProAction();
		}
		/*
	 	else if ("패스값"){		
			// action = new action생성
		}
		*/
		return action;
	}	
}

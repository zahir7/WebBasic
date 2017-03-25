package mvc.controller;

import mvc.action.MvcTestAction;

public class UserActionFactory {
	
	// 싱글톤으로 만들기 위한 객체
	private static UserActionFactory uaf;
	
	
	// 생성자를 private로 해서 외부에서 객체 생성하지 못하도록 한다.
	private UserActionFactory() {}
	
	// 자신의 객체를 리턴하는 메소드를 만든다.
	public static UserActionFactory getInstance(){
		if(uaf==null){
			uaf = new UserActionFactory();
		}
		return uaf;
	}
	
	// 전달되는 command 값에 따라 필요한 액션 객체를 생성해서 리턴한다.
	public SuperAction getAction(String command){
		SuperAction action = null;
		if(command.equals("/mvcTest")){
			action = new MvcTestAction();			
		}		
		return action;
	}

}

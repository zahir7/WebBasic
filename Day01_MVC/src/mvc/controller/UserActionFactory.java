package mvc.controller;

import mvc.action.MvcTestAction;

public class UserActionFactory {
	
	// �̱������� ����� ���� ��ü
	private static UserActionFactory uaf;
	
	
	// �����ڸ� private�� �ؼ� �ܺο��� ��ü �������� ���ϵ��� �Ѵ�.
	private UserActionFactory() {}
	
	// �ڽ��� ��ü�� �����ϴ� �޼ҵ带 �����.
	public static UserActionFactory getInstance(){
		if(uaf==null){
			uaf = new UserActionFactory();
		}
		return uaf;
	}
	
	// ���޵Ǵ� command ���� ���� �ʿ��� �׼� ��ü�� �����ؼ� �����Ѵ�.
	public SuperAction getAction(String command){
		SuperAction action = null;
		if(command.equals("/mvcTest")){
			action = new MvcTestAction();			
		}		
		return action;
	}

}

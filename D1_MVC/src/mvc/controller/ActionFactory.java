package mvc.controller;

import mvc.action.FormProAction;
import mvc.action.SuperAction;

public class ActionFactory {
	
	// �̱��� ������� ����ϱ����� ���� ����
	private static ActionFactory af;

	// �ܺο��� ��ü ������ �������� ���������ڸ� private���� �Ѵ�.
	private ActionFactory(){}
	
	public static SuperAction getInstance(String path){
		
		SuperAction action = null;
		
		// path�� �������� �ش�׼� ��ü ����
		if(path.equals("/mvcTest")){
			action = new FormProAction();
		}
		/*
	 	else if ("�н���"){		
			// action = new action����
		}
		*/
		return action;
	}	
}

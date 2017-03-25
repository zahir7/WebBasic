package mvc.controller;

public class ActionForward {
	private String path;
	private boolean isRedirect = false;
	
	// ������(Forward�� �̵��ϰ��� �� �� ȣ���ϴ� ������
	public ActionForward(String path){
		this.path = path;
	}
	
	public ActionForward(String path, boolean isRedirect){
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	

}

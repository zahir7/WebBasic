package mvc.controller;

public class ActionForward {
	private String path;
	private boolean isRedirect = false;
	
	// 생성자(Forward로 이동하고자 할 때 호출하는 생성자
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

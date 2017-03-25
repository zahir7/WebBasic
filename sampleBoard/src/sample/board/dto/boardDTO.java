package sample.board.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class boardDTO {
	
	private List<boardDTO> list;
	private int no;
	private String title;
	private String contents;	
	private String upfile;
	private String writer;
	private Date reg;	
	private String fdate;
	
	public List<boardDTO> getList() {
		return list;
	}
	public void setList(List<boardDTO> list) {
		this.list = list;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {		
		this.reg = reg;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	
		
}

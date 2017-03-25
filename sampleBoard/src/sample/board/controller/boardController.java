package sample.board.controller;

import java.io.File;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import sample.board.dto.boardDTO;

@Controller
public class boardController {
	

	public static Reader reader;	
	public static SqlMapClient sqlMapper;	
	List<boardDTO> list = null;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	


	public boardController() throws Exception {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();		//한번 객체 생성할때 올려둔다 
	}
	
	//메인
	@RequestMapping("/boardList.do") 
	public ModelAndView board(HttpServletRequest request, @ModelAttribute boardDTO dto) throws Exception{
		
		list = new ArrayList<boardDTO>();
		list = sqlMapper.queryForList("boardSQL.selectAll");		
		
		
		
		
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("list" , list);		
		mv.setViewName("/board/boardList.jsp");	
		
		return mv;
	}
	

	
}

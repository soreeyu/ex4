package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;

@Controller
@RequestMapping(value="/notice/**") 
public class NoticeController {
	
	
	@Inject //type
	private NoticeServiceImpl noticeService;
	
	
	//List
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String noticeList(@RequestParam(defaultValue="1")Integer curPage, Model model) throws Exception{
		
		List<BoardDTO> ar =noticeService.boardList(curPage);
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		return "board/boardList";
	}
	//View
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void noticeView(@RequestParam(defaultValue="324")Integer num, Model model) throws Exception{
		
		BoardDTO boardDTO = noticeService.boardView(num);
		model.addAttribute("dto", boardDTO);
				
	}
	//Write
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public void noticeWrite(Model model){
		model.addAttribute("path", "Write");
	}
	//Write
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(RedirectAttributes redirectAttributes,NoticeDTO noticeDTO) throws Exception{
		
		int result = noticeService.boardWrite(noticeDTO);
		
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		
		return "redirect:noticeList";
		
	}
	//Update
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String noticeUpdate(Model model,Integer num) throws Exception{
		BoardDTO boardDTO = noticeService.boardView(num);
		
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Update");
		return "notice/noticeWrite";
	}
	
	
	//Update
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(RedirectAttributes redirectAttributes, NoticeDTO noticeDTO) throws Exception{
		
		int result = noticeService.boardUpdate(noticeDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList";
		
	}
	//Delete
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String noticeDelete(RedirectAttributes redirectAttributes,Integer num) throws Exception{
		
		int result = noticeService.boardDelete(num);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList";
	}

}

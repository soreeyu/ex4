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
import com.choa.freeboard.FreeboardDTO;
import com.choa.freeboard.FreeboardServiceImpl;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeboardController {
	
	@Inject
	private FreeboardServiceImpl freeboardService;

	
	@RequestMapping(value="freeboardList" , method=RequestMethod.GET)
	public String FreeboardList(Model model,@RequestParam(defaultValue="1")Integer curPage) throws Exception{
		List<BoardDTO> ar =freeboardService.boardList(curPage);
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "freeboard");
		return "board/boardList";
	}
	
	@RequestMapping(value="freeboardWrite" , method=RequestMethod.GET)
	public void FreeboardWrite(Model model) throws Exception{
		model.addAttribute("path", "Write");
	}
	
	@RequestMapping(value="freeboardWrite" , method=RequestMethod.POST)
	public String FreeboardWrite(Model model,FreeboardDTO freeboardDTO) throws Exception{
		int result =freeboardService.boardWrite(freeboardDTO);
		String msg = "FAIL";
		if(result > 0){
			msg = "SUCCESS";
		}
		
		model.addAttribute("message", msg);
		return "redirect:freeboardList";
	}
	
	@RequestMapping(value="freeboardView", method=RequestMethod.GET)
	public void FreeboardView(Model model, @RequestParam(defaultValue="1")Integer num) throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO = (FreeboardDTO)freeboardService.boardView(num);
		
		model.addAttribute("dto", boardDTO);
		
	}
	
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.GET)
	public String FreeboardUpdate(Model model,Integer num) throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO = freeboardService.boardView(num);
		
		model.addAttribute("dto", boardDTO);
		
		model.addAttribute("path", "Update");
		return "freeboard/freeboardWrite";
	}
	
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.POST)
	public String FreeboardUpdate(RedirectAttributes redirectAttributes, FreeboardDTO freeboardDTO) throws Exception{
		int result = freeboardService.boardUpdate(freeboardDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/freeboard/freeboardList";
	}
	
	
}

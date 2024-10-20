package orgsh.boardpro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import orgsh.boardpro.dto.BoardDTO;
import orgsh.boardpro.dto.PageRequestDTO;
import orgsh.boardpro.service.BoardService;

import java.util.List;

@Log4j2
@Controller
    // MVC 중 Controller 역할, Bean으로 등록됨.
@RequiredArgsConstructor
    // final로 선언된 field(필수 인자)만을 가지는 생성자(Constructor) 자동 생성. => 생성자가 필요한 필드를 자동으로 초기화하여 의존성 주입을 용이하게 함.(코드 짧, 가독 높)
@RequestMapping("/board")
    // HTTP 요청의 URL 경로와 메서들를 Mapping하여 request 처리.
    // HTTP요청의 URL경로를 처리할 때, Get/Post인가 or URL path 를 정의
public class BoardController {

    private final BoardService boardService; //MVC구조에서 service와 controller 같은 애들은 parameter로 받을 수 없기에 여기서 선언.
                                             //   서비스는 DTO와 VO(순수하게 데이터만 전달)를 변환



    //("/list")
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        List<BoardDTO> boardList= boardService.getAll();
        model.addAttribute("boardList", boardList);
        //return "board/list";

    }
    //("/register")
    @GetMapping("/register")
    public void registerGet(){
    }

    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        log.info("registerPost()"+boardDTO);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult);
            return "redirect:/board/register";
        }
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    //("/read", "/modify")
    @GetMapping({"/read","/modify"})
    public void read(@RequestParam("bno") int bno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("read");
        BoardDTO boardDTO=boardService.getOne(bno);
        model.addAttribute("dto",boardDTO);
    }

    //("/modify")
    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
        log.info("modify()"+boardDTO);
        boardService.modify(boardDTO);
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        redirectAttributes.addFlashAttribute("pageRequestDTO", pageRequestDTO);
        return "redirect:/board/read";
    }
    //("/remove")
    @PostMapping("/remove")
    public String remove(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        log.info("remove()");
        boardService.remove(Math.toIntExact(boardDTO.getBno()));
        return "redirect:/board/list";

    }
}

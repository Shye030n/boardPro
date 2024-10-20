package orgsh.boardpro.service;

import jakarta.validation.Valid;
import orgsh.boardpro.dto.BoardDTO;
import orgsh.boardpro.dto.PageRequestDTO;
import orgsh.boardpro.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    void register(@Valid BoardDTO boardDTO); //인터페이스 만들고
    List<BoardDTO> getAll();
    BoardDTO getOne(int bno);
    void remove(int bno);
    void modify(BoardDTO boardDTO);

    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

}

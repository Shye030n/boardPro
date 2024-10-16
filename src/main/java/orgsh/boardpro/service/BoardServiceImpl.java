package orgsh.boardpro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import orgsh.boardpro.dto.BoardDTO;
import orgsh.boardpro.mapper.BoardMapper;
import orgsh.boardpro.vo.BoardVO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<BoardDTO> getAll() {
        log.info("service getAll");

        List<BoardVO> voList=boardMapper.getList();
        List<BoardDTO> dtoList=voList.stream().map(vo->modelMapper.map(vo,BoardDTO.class))
                .collect(Collectors.toUnmodifiableList());
        return dtoList;
    }

    @Override
    public void register(BoardDTO boardDTO) {
//        log.info("service register"+boardDTO);
//        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
//        log.info(boardVO);
//        boardMapper.insert(boardVO);
    }


    @Override
    public BoardDTO getOne(int bno) {
        return null;
    }

    @Override
    public void remove(int tno) {
//        log.info("service remove");
//        boardMapper.delete(tno);
    }

    @Override
    public void modify(BoardDTO todoDTO) {
//        BoardVO todoVO=modelMapper.map(todoDTO, BoardVO.class);
//        boardMapper.update(todoVO);
    }
//    @Override
//    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO){
////        List<BoardVO> voList=boardMapper.selectList(pageRequestDTO);
////        List<BoardDTO> dtoList=voList.stream().map(vo->modelMapper.map(vo,BoardDTO.class)).collect(Collectors.toUnmodifiableList());
////        int total=boardMapper.getCount(pageRequestDTO);
////        PageResponseDTO<BoardDTO> pageResponseDTO=PageResponseDTO.<BoardDTO>withAll()
////                .dtoList(dtoList)
////                .total(total)
////                .pageRequestDTO(pageRequestDTO)
////                .build();
////        return pageResponseDTO;
//
//    }
}




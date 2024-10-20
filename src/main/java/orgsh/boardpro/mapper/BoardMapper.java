package orgsh.boardpro.mapper;

import orgsh.boardpro.dto.PageRequestDTO;
import orgsh.boardpro.vo.BoardVO;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> getList();

    List<BoardVO>selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

    String getTime();
    void insert(BoardVO boardVO); //추상메서드 삽입


    BoardVO selectOne(int bno);
    void delete(int dto);
    void update(BoardVO boardVo); // BoardMapper 인터페이스에 정의
}

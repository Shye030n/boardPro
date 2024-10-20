package orgsh.boardpro.mapper;

import orgsh.boardpro.dto.BoardDTO;
import orgsh.boardpro.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mariadb.jdbc.plugin.codec.LocalDateCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Date;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardMapperTest {
    @Autowired(required = false) // 주입할 수 있는 빈이 없더라도 정상적으로 애플리케이션을 실행하도록.
    //@Autowired(required = true)  주입할 수 있는 빈이 없으면 애플리케이션이 실행할 때 에러 발생.
    private BoardMapper BoardMapper;
    // 이 클래스에서 BoardMapper.java에서 만든 getTime()메서드를 사용하기 위해
    // 클래스를 갖고와서 boardMapper라 클래스 선언
    // ! 선언만 함 !
    private BoardService boardService; //클래스 객체 생성 = 클래스 선언


    @Test
    public void testGetTime(){
        log.info(boardMapper.getTime());
        //정보기록지(boardMapper의 getTime을 호출
        // ! 사용함
    }

    @Test
    public void testInsert() throws Exception{
        BoardDTO dto=new BoardDTO();
        dto.setTitle("목제");
        dto.setPostDate(LocalDate.now());
        dto.setWriter("작가");
        //boardService.register((dto));
        //boardMapper.insert(dto);

    }
}

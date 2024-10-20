package orgsh.boardpro.vo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
/* VO(ValueObject)란? (폴더명 및 파일명)
- DB에서 가져온 데이터나 사용자 입력을 표현하는 객체
- Address(주소), Date(날짜), Point(좌표) 등 특정한 의미를 가진 데이터 구조.
- 일반적으로 불변 객체(ImmutableObject 생성 후 변경 X)로 설계됨
    -> 데이터 안전 유지, 여러 스레드 동시접근 문제 예방
- 주로 Property(속성)으로 구성되며 getter만 가지고 있는 경우가 많다.
- 데이터 모델링에서 중요한 역할, 도메인 모델을 구성하는데 사용
- 비즈니스 의미를 가진 불변 객체로, 데이터를 안전하게 표현하고 관리.
    -> 코드의 가독성을 높이고 데이터 무결성 유지 */

@Getter
    //클래스에서 모든 속성에 대한 getter메서드를 자동 생성
@ToString
    // '객체 -> 문자열' 변환하는 기능 (객체를 사용자가 읽을 수 있는 문자열 형태로 변환해주는 메서드)
@AllArgsConstructor
    // parameter O 생성자(Constructor) 자동 생성
@NoArgsConstructor
    // default Constructor(생성자) 자동 생성
public class BoardVO {
    //Mysql == BoardVO == BoardDTO
    private int bno;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;

    private LocalDate postDate;
    private int visitcount;
}

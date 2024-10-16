package orgsh.boardpro.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.MemberSubstitution;

@Data
    // getter/setter, toString() 자동 생성
@AllArgsConstructor
    //클래스의 모든 field(속성)를 매개변수(parameter)로 갖는 생성자를 자동 생성
    // =>  객체 생성 시 모든 필드에 값을 설정 가능.
@NoArgsConstructor // default 생성자를 자동 생성 (parameter없는 객체 자동 생성)
@Builder
    // 빌더 패턴을 사용할 수 있게 해 줌
    // => 생성자가 길어질 경우, 각 필드를 순차적으로 설정할 수 있도록 도와줌
    // => 객체를 보다 유연하고 가독성있게 생성하게 함.
public class BoardDTO {
    //Mysql == BoardVO == BoardDTO
    private int bno;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;

    private String postDate;
    private int visitCount;
}

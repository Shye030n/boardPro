package orgsh.boardpro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    // MVC 중 Controller 역할, Bean으로 등록됨.
@RequiredArgsConstructor
    // final로 선언된 field(필수 인자)만을 가지는 생성자(Constructor) 자동 생성. => 생성자가 필요한 필드를 자동으로 초기화하여 의존성 주입을 용이하게 함.(코드 짧, 가독 높)
@RequestMapping("/Board")
    // HTTP 요청의 URL 경로와 메서들를 Mapping하여 request 처리.
    // HTTP요청의 URL경로를 처리할 때, Get/Post인가 or URL path 를 정의
public class BoardController {

    //("/register")

    //("/list")

    //("/modify")

    //("/list")

    //("/read", "/modify")

}

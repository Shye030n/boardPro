package orgsh.boardpro.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정클래스 임을 알려줌
public class ModelMapperConfig {

    // ** 총 정리 **
    // ModelMapperConfig(클래스) > getMapper()(메서드) > modelMapper(객체)

    // => @Configuration으로 설정 클래스임을 정의하고,
    // getMapper()메서드를 통해 ModelMapper의 객체인 modelMapper를 return(반환)하여,
    // 외부에서 호출할 수 있도록 설정한 클래스.

    @Bean
    public ModelMapper getMapper() { // ModelMapper의 객체(getMapper)를 반환하는 메서드
                                        // => ModelMapper 객체를 외부에서 접근할 수 있게 함.

        ModelMapper modelMapper = new ModelMapper(); // modelMapper 객체 생성
        // ModelMapper : java에서 객체간의 데이터전송을 도와주는 라이브러리.

        modelMapper.getConfiguration() // .getConfiguration() 설정 정보를 가져올 때
                .setFieldMatchingEnabled(true) //field (이름과 설정 값) 매칭기능을 킴.
                    // => 프로그램이 설정 값을 읽어온 뒤 필드 이름과 설정 값을 자동으로 연결. <-> false 끔
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
                    // field의 접근 권한을 제어
                    // 보통 java에서는 private은 필드 외부에서 접근 할 수 없기에 getter/setter로 접근 해야 하지만,
                    // .setFieldAccessLevel 설정을 사용하면 ModelMapper가 클래스 내부의 private 필드에도 직접 접근이 가능하여
                    // getter/setter메서드 없이, 객체 필드의 값을 자동으로 mapping 해 줌.)
                //.setMatchingStrategy(MatchingStrategy.LOOSE);
                    // mapping 전략 방식 ( 엄격 or 느슨)
                    // 객체 필드의 이름이 정확히 일치 않아도 비슷하면 자동으로 매핑!
                    // => 자동으로 유연하게 필드를 매핑 해 줌.

                    // 객체 필드 : 클래스의 속성이나 특징을 나타내는 변수 !
                    // 생성자 : 클래스의 인스턴스(객체)를 생성할 때 호출되는 특별한 메서드
                    // (객체가 만들어질 때 필요나 초기 설정을 수행하는 역할)
                        // - 생성자의 이름 = 클래스명
                        // - 생성자는 return(반환) 타입이 없기 때문에, void를 쓰지 않아도 됨.
                        // - 생성자는 여러개 정의 가능 ( 매개변수의 개수나 타입이 다르면 서로 다른 생성자로 인식 : 생성자 오버로딩

        return modelMapper; // 객체를 반환
                                //반환 : 나중에 호출할 때 사용할 수 있도록 설정이나 값을 저장.

    }
}

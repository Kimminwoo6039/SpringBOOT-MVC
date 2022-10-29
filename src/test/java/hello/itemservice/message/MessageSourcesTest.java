package hello.itemservice.message;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MessageSourcesTest {



    @Autowired
    MessageSource messageSource;


    @Test
    void Message(){
        String result = messageSource.getMessage("hello",null,null,null);
        AssertionsForClassTypes.assertThat(result).isEqualTo("여기한국서버야");

    }


    @Test
    void notFoundMessageCode(){

        assertThatThrownBy(() -> messageSource.getMessage("no_code",null,null)) //no_code란게 메시지프로퍼티에없음
                .isInstanceOf(NoSuchMessageException.class); //예외처리

    }

    @Test
    void notFoundMessageCodeDefalut(){
        String result = messageSource.getMessage("no_code",null,"기본 메시지",null);
        assertThat(result).isEqualTo("기본 메시지"); // 메시지를 못찾으면 defalt 메시지 찾음
    }


    @Test
    void argumentMessage(){
        String result = messageSource.getMessage("hello.name",new Object[]{"spring"},null);
        assertThat(result).isEqualTo("한국 spring"); // 한국 {0} == {0} <= 이부분이 spring 으로 변환
    }

    @Test
    void defaultLang(){
        assertThat(messageSource.getMessage("hello",null,null)).isEqualTo("여기한국서버야");
        assertThat(messageSource.getMessage("hello",null, Locale.KOREA)).isEqualTo("여기한국서버야");
    }


    @Test
    void enLang(){
        assertThat(messageSource.getMessage("hello",null,Locale.ENGLISH)).isEqualTo("hi"); //영어버전
    }
}

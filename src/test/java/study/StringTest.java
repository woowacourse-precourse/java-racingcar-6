package study;

import domain.GameInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

//테스트코드 작성방법
//https://velog.io/@dgh06175/Java-JUnit5-%EA%B3%BC-AssertJ-%EB%A1%9C-%EB%8B%A8%EC%9C%84-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0
public class StringTest {

    @Test
    void userGameTries_테스트(){
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        assertThat(GameInput.userGameTries()).isEqualTo(123);
    }
    @Test
    void userGameTries_오류_테스트(){
        System.setIn(new ByteArrayInputStream("asdf".getBytes()));
        assertThatThrownBy(() -> GameInput.userGameTries())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void userCarNameInput_테스트(){
        System.setIn(new ByteArrayInputStream("1234,asdfg,asdf".getBytes()));
        assertThat(GameInput.userCarNameInput()).asList();
    }
    @Test
    void userCarNameInput_문자열_테스트(){
        System.setIn(new ByteArrayInputStream("1234,asdfg,asdf".getBytes()));
        assertThat(GameInput.userCarNameInput()).contains("1234,asdfg,asdf");
    }
    @Test
    void userCarNameInput_오류_테스트(){
        System.setIn(new ByteArrayInputStream("1234,asdfg,asdf,asdfgk".getBytes()));
        assertThatThrownBy(() -> GameInput.userCarNameInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

}

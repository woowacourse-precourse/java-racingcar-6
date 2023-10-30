package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.askCarNames;

public class CarNameTest {
    void setInputStream(String carNames) {
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
    }

    @AfterEach
    void closeInputStream() {
        close();
    }

    @Test
    void 정상_테스트_차_이름_입력() {
        // given
        setInputStream("char,int,for,bool");

        // when
        List<String> carNames = askCarNames();

        // then
        assertThat(carNames).containsExactly("char", "int", "for", "bool");
    }

    @Test
    void 정상_테스트_차_이름_긴_입력() {
        // given
        String carNamesInput = "char,int,for,bool,class,input,text,read,java,test,build";
        setInputStream(carNamesInput);

        // when
        List<String> carNames = askCarNames();

        // then
        assertThat(carNames).containsExactly("char", "int", "for", "bool", "class", "input", "text", "read", "java", "test", "build");
    }

    @Test
    void 예외_테스트_길이_0인_차_이름_입력() {
        // given
        setInputStream("char,,int");

        // when, then
        assertThatThrownBy(Application::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_길이_6이상인_차_이름_입력() {
        // given
        setInputStream("string,int");

        // when, then
        assertThatThrownBy(Application::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }
}

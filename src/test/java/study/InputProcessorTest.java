package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputProcessor;

@DisplayName("입력 프로세서 테스트")
public class InputProcessorTest {

    @AfterEach
    void reset() {
        Console.close();
    }

    @DisplayName("성공: 입력값에 쉼표가 없는 경우")
    @Test
    void test1() {
        System.setIn(new ByteArrayInputStream("pobigokim".getBytes()));
        InputProcessor inputProcessor = new InputProcessor();
        assertThatCode(()->inputProcessor.getCarNames())
                .doesNotThrowAnyException();
    }

    @DisplayName("실패: 자동차 이름에 공백을 입력할 수 없다.")
    @Test
    void test2() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
        InputProcessor inputProcessor = new InputProcessor();
        assertThatThrownBy(()->inputProcessor.getCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("성공: 자동차 이름을 쉼표를 기준으로 여러개 입력할 수 있다.")
    @Test
    void test3() {
        final List<String> names = List.of(new String[]{"pobi", "wooni"});
        System.setIn(new ByteArrayInputStream(String.join(",",names).getBytes()));
        InputProcessor inputProcessor = new InputProcessor();
        assertThat(inputProcessor.getCarNames().size()).isEqualTo(names.size());
    }
}

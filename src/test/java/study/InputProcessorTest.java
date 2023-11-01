package study;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputProcessor;

@DisplayName("입력 프로세서 테스트")
public class InputProcessorTest {

    @DisplayName("성공: 입력값에 쉼표가 없는 경우")
    @Test
    void test1() {
        System.setIn(new ByteArrayInputStream("pobigokim".getBytes()));
        InputProcessor inputProcessor = new InputProcessor();
        assertThatCode(()->inputProcessor.getCarNames())
                .doesNotThrowAnyException();
    }
}

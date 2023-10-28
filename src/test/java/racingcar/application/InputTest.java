package racingcar.application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

@DisplayName("입력 기능 테스트")
class InputTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "      ", "\n","\r\n", "\r"})
    void 공백_입력_값_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ,  ", "pobi,   , jun"})
    void 쉼표_기준_공백_입력_값_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"eng;123;456", "a;b", "쉼표로'구분'안함", "쉼.표.없"})
    void 구분자_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "12345,abcde,다섯글자야,!@#$%"})
    void 정상_입력_값_테스트(String input) {
        assertSimpleTest(() ->
                assertThatCode(() ->
                        runException(input)).doesNotThrowAnyException()
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

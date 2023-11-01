package racingcar.exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameExceptionTest extends NsTest {

    @Test
    void 자동차이름길이확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("overFiveWord,may", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5자초과입니다,may", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 자동차이름중복확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hi,hi,hello", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hi,hello,hi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름공백확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("july ,april,march", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("july,a  il,march", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("july ,april, ", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
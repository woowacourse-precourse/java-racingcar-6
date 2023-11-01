package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Cars;

public class CarNameTest extends NsTest {
    @Test
    void 자동차_이름_검증하기() {
        Cars cars = new Cars();
        List<String> carNames1 = Arrays.asList("pobi", "woni", "jun");

        assertThatCode(() -> cars.validateCarNames(carNames1)).doesNotThrowAnyException();
    }

    @Test
    void 이름_예외_처리_빈_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,j un"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_6자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jjuunn"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

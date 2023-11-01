package racingcar.global;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ValidationTest extends NsTest {

    @Test
    @Name("이름이 5자 이상일 때 예외 처리")
    void validateName() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("moreThanFive"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @Name("라운드에 0이 상의 숫자가 들어오지 않을때 예외처리")
    void validateRound() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("user", "text"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("user", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
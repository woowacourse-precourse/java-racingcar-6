package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RacingRoundValidatorTest extends NsTest {
    @Test
    @DisplayName("validateInputNotEmpty 함수 기능 테스트")
    void 라운드_횟수가_공백일_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora,dori", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("validateIsParsableToInt 함수 기능 테스트")
    void 라운드_횟수가_숫자가_아닐_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora,dori", "이"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora,dori", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

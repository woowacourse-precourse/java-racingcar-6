package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarsValidatorTest extends NsTest {
    @Test
    @DisplayName("validateDuplicateName 함수 기능 테스트")
    void 중복된_자동차_이름에_대한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora,bora", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("validateInputCount 함수 기능 테스트")
    void 자동차가_1대일_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("validateInputWithSeparator 함수 기능 테스트")
    void 구분자가_쉼표가_아닐_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bora.bora", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("borabora", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("validateNotEmpty 함수 기능 테스트")
    void 빈_값_입력_시_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

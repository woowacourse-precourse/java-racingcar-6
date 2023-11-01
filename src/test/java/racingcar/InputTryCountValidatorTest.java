package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputTryCountValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTryCountValidatorTest {

    InputTryCountValidator inputTryCountValidator = new InputTryCountValidator();

    @Test
    @DisplayName("시도 횟수 입력을 안한 경우 테스트")
    void 시도_횟수_입력_안함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputTryCountValidator.validateNonInputTryCount(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 숫자가 아닌 경우 테스트")
    void 시도_횟수_숫자_아님_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputTryCountValidator.validateNonIntegerTryCount("6번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 1이상 아닌 경우 테스트")
    void 시도_횟수_1이상_아님_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputTryCountValidator.validateNonOverOneTryCount("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 음수인 경우 테스트")
    void 시도_횟수_음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputTryCountValidator.validateMinusTryCount("-8"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

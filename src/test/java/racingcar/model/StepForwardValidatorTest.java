package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.constant.StepConstant.MOVING_FORWARD;
import static racingcar.constant.StepConstant.STOP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StepForwardValidator;

class StepForwardValidatorTest {

    @DisplayName("무작위 숫자가 전진 해야하는 값일 경우 true를 반환한다.")
    @Test
    void success_isCarStepForward_true() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean result = StepForwardValidator.isCarStepForward();
                    Assertions.assertThat(result).isTrue();
                },
                MOVING_FORWARD
        );
    }

    @DisplayName("무작위 숫자가 멈춤 하는 값일 경우 false를 반환한다.")
    @Test
    void success_isCarStepForward_false() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean result = StepForwardValidator.isCarStepForward();
                    Assertions.assertThat(result).isFalse();
                },
                STOP
        );
    }
}

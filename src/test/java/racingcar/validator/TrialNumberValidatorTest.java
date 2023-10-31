package racingcar.validator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TrialNumberValidatorTest {

    @Test
    void 시도횟수에_빈문자_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> TrialNumberValidator.checkTrialNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_정수_입력_안함() {
        assertSimpleTest(() -> assertThatThrownBy(() -> TrialNumberValidator.checkTrialNumberInput("2.8"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

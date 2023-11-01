package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;


class ValidationManagerTest {

    @Test
    void 시도_횟수_유효성_검사1() {

        String unvalidTrial = "notanumber";
        assertThatThrownBy(() -> ValidationManager.validateTrials(unvalidTrial))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_유효성_검사2() {
        assertThatThrownBy(() -> ValidationManager.validateTrials("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_유효성_검사3() {

        String validTrial = "3";
        // When & Then
        assertThatCode(() -> ValidationManager.validateTrials(validTrial))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름에_대한_길이_검증1() {
        String[] validNames = {"Car1", "Car2", "C3", "C_4", "C-5"};

        assertThatCode(() -> ValidationManager.validateCarNames(validNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름에_대한_길이_검증2() {
        String longName = "longlonglongname";
        assertThatThrownBy(() -> ValidationManager.validateTrials(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
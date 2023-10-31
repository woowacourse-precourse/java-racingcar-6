package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RaceValidatorTest {

    private RaceValidator raceValidator = new RaceValidator();

    @Test
    @DisplayName("자동차 이름 입력에 쉼표가 없으면 예외 발생")
    void validateSeparator() {
        String includeComma = "자동차1,자동차2";
        String notIncludeComma = "자동차1자동차2";
        assertThatNoException().isThrownBy(() -> raceValidator.validateSeparator(includeComma));
        assertThatThrownBy(() -> raceValidator.validateSeparator(notIncludeComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과하면 예외 발생")
    void validateCarname() {
        String carname1 = "소나타";
        String carname2 = "소나타 하이브리드";
        assertThatNoException().isThrownBy(() -> raceValidator.validateCarname(carname1));
        assertThatThrownBy(() -> raceValidator.validateCarname(carname2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void validateMoveTrialCount() {
        String moveTrialCount1 = "111";
        String moveTrialCount2 = "c";
        assertThatNoException().isThrownBy(() -> raceValidator.validateMoveTrialCount(moveTrialCount1));
        assertThatThrownBy(() -> raceValidator.validateMoveTrialCount(moveTrialCount2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
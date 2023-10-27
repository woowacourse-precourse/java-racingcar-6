package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private static final String CAR_NAME_LONG = "자동차 이름의 길이가 5를 초과하였습니다. : ";
    private static final String SEPARATOR = ",";

    @Test
    void validateRacingCarNames_자동차_이름_길이가_5를_초과하는_경우01() {
        String racingCarNames = "a,b,cccccc";
        String[] carNames = racingCarNames.split(SEPARATOR);

        assertThatThrownBy(() -> InputValidator.validateRacingCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(CAR_NAME_LONG);
    }

    @Test
    void validateRacingCarNames_자동차_이름_길이가_5를_초과하는_경우02() {
        String racingCarNames = "aaaaaa,bbbbbb,cccccc";
        String[] carNames = racingCarNames.split(SEPARATOR);

        assertThatThrownBy(() -> InputValidator.validateRacingCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(CAR_NAME_LONG);
    }

}
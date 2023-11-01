package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private static final String CAR_NAME_LONG = "자동차 이름의 길이가 5를 초과하였습니다. : ";
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
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

    @Test
    void validateTryCount_시도횟수가_영어인_경우() {
        String tryCount = "asd";

        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NOT_NUMBER);
    }

    @Test
    void validateTryCount_시도횟수가_숫자와_영어가_섞인_경우01() {
        String tryCount = "5a";

        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NOT_NUMBER);
    }

    @Test
    void validateTryCount_시도횟수가_숫자와_영어가_섞인_경우02() {
        String tryCount = "a5";

        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NOT_NUMBER);
    }

}
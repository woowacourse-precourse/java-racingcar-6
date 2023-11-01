package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {

    private static final String YOUTH = "youth";
    private static final String MINJAE = "Kim";
    private static final String JINSU = "Kim";
    private static final String HEUNGMIN = "Sonny!";
    private static final String DELIMITER = ", ";
    private static final String EMPTY_STRING = " ";


    @Test
    void 중복된_이름_예외_처리() {
        //given
        final String carNames = YOUTH + DELIMITER + JINSU + DELIMITER + MINJAE;

        //then
        Assertions.assertThatThrownBy(() -> ValidateInput.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_예외_처리() {
        //given
        final String carNames = YOUTH + DELIMITER + HEUNGMIN;

        //then
        Assertions.assertThatThrownBy(() -> ValidateInput.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_이름_예외_처리() {
        //given
        final String carNames = YOUTH + DELIMITER + EMPTY_STRING + DELIMITER + MINJAE;

        //then
        Assertions.assertThatThrownBy(() -> ValidateInput.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수가_아닌_게임_시도_횟수_예외_처리() {
        //given
        final String gameCount = YOUTH;

        //then
        Assertions.assertThatThrownBy(() -> ValidateInput.validateGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

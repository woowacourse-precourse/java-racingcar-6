package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class ExceptionCaseTest {
    ExceptionCase exceptionCase = new ExceptionCase();

    @DisplayName("자동차 이름은 6자 이상이면 exception 발생")
    @Test
    void nameLengthCheck() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.carNameLength("pobi,javaji"));
    }

    @DisplayName("입력값 없으면 exception 발생")
    @Test
    void checkIsValueBlank() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nullStringInput(""));
    }

    @DisplayName("null 입력시 exception 발생")
    @Test
    void checkIsValueNull() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nullStringInput(null));
    }

    @DisplayName("0~9보다 큰 수를 입력시 exception")
    @Test
    void digitOver9() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.isNumberCorrect(99));
    }

}
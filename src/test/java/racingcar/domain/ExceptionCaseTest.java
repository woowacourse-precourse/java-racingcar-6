package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class ExceptionCaseTest {
    ExceptionCase exceptionCase = new ExceptionCase();
    
    @DisplayName("자동차 이름은 6자 이상이면 exception 발생")
    @Test
    void nameLengthCheck() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.carNameLength(Arrays.asList("pobi,javaji")));
    }

    @DisplayName("공백 입력시 exception 발생")
    @Test
    void isValueBlank() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nullStringInput(""));
    }

    @DisplayName("null 입력시 exception 발생")
    @Test
    void isValueNull() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nullStringInput(null));
    }

}
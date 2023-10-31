package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class ExceptionCaseTest {
    ExceptionCase exceptionCase = new ExceptionCase();

    @Test
    void 예외_nameValidation_글자수_6자_이상() {
        String[] racers = {"pobi","javaji"};
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nameInputValidation(racers));
    }
    @Test
    void 예외_nameValidation_자동차_1대_입력() {
        String[] racers = {"pobi"};
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionCase.nameInputValidation(racers));
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
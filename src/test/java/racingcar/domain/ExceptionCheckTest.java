package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.ExceptionCheck.*;

class ExceptionCheckTest {

    @Test
    void 자동차_이름_길이_5초과_시_검증() {
        String[] carsNameArray = {"aaaaa", "abcdefg", "aaa"};

        assertThatThrownBy(() -> isCarNameInputLengthValidate(carsNameArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 반복횟수_입력_값_오류_검증() {
        String repetitionNumberInput = "a";

        assertThatThrownBy(() -> isRepetitionNumberInputTypeValidate(repetitionNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 반복횟수_입력_값_자연수가_아닌_경우() {
        String repetitionNumberInput = "0";

        assertThatThrownBy(() -> isRepetitionNumberInputRangeValidate(repetitionNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
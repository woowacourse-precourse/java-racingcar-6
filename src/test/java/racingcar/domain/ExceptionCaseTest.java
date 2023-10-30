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

}
package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

public class ValidatorTest {
    @DisplayName("자동차 이름 입력값이 쉼표로 구분되었는지 검사")
    @Test
    void 자동차_이름_쉼표_구분_테스트() {
        // given
        String case1 = "pobi.woni.jun";
        String case2 = "pobi,woni,jun";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateSeparatedByComma(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateSeparatedByComma(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }
}

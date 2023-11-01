package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryCountValidatorTest {
    @Test
    void 올바른_입력() {
        //given
        String input = "4";

        //when
        TryCountValidator tryCount = new TryCountValidator(input);

        //then
        assertThat(tryCount).isNotNull();
    }

    @Test
    void 올바르지_않은_입력() {
        //given
        String input = "ㅇ";
        String input2 = "=-5";

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TryCountValidator(input);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TryCountValidator(input2);
        });
    }

}
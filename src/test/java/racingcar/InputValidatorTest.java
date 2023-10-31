package racingcar;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @Test
    void 이름은_5자_이하여야_함() {
        //given
        String input = "pobi,Elizabeth";

        //when
        Throwable thrown = catchThrowable(() -> {
            InputValidator.validateCarNames(input);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ","})
    void 하나_이상의_이름이_입력되어야_함(String input) {
        //when
        Throwable thrown = catchThrowable(() -> {
            InputValidator.validateCarNames(input);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 없습니다.");
    }

    @Test
    void 이름은_쉼표_기준으로_구분함() {
        //given
        String input = "pobi,woni,jun";

        //when
        List<String> carNames = InputValidator.validateCarNames(input);

        //then
        assertThat(carNames).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "5.5", "0", ""})
     void 시도_회수는_양의_정수여야_함(String input) {
        //when
        Throwable thrown = catchThrowable(() -> {
            InputValidator.validateNumberOfAttempts(input);
        });

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
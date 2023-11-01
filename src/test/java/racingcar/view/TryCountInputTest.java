package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.util.ValidateTryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TryCountInputTest {

    @Test
    void 시도_횟수_정상_입력_테스트(){

        // given
        String input = "5";

        // when
        int result = ValidateTryCount.validateInputValue(input);

        // then
        assertThat(result).isEqualTo(5);

    }

    @Test
    void 시도_횟수_음수_입력(){

        // given
        String input = "-1";

        // when
        Throwable thrown = catchThrowable(() -> ValidateTryCount.validateInputValue(input));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1이상만 가능합니다.");

    }

}

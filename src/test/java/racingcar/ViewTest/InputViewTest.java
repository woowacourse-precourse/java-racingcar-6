package racingcar.ViewTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.View.InputView;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void inputRacingCarName_자동차_이름_양옆에_공백이_있을경우() {
        // given
        System.setIn(createUserInput(" abc,  ssaf , ssa   , ss"));

        // when, then
        Assertions.assertThat(InputView.inputRacingCarName()).isEqualTo(List.of("abc","ssaf","ssa","ss"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "xyz", "123a", "!!!", "  ", "\n"})
    void inputRacingRoundTimes_입력값이_숫자가_아닐경우(String nonNumericInput) {
        // given
        System.setIn(createUserInput(nonNumericInput));

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputRacingRoundTimes();
        });
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

package racingcar.view;

import static racingcar.exception.InputErrorCode.BLANK_INPUT;
import static racingcar.exception.InputErrorCode.NEGATIVE_INTEGER_INPUT;
import static racingcar.exception.InputErrorCode.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    void 시도_횟수로_음수를_받을_시_예외를_던진다() {
        // given
        final String input = "-123";
        command(input);

        // when & then
        Assertions.assertThatThrownBy(InputView::inputAttemptCount)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NEGATIVE_INTEGER_INPUT.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"q2e1", "...", "  /"})
    void 시도_횟수로_숫자_이외의_값을_받을_시_예외를_던진다(final String input) {
        // given
        command(input);

        // when & then
        Assertions.assertThatThrownBy(InputView::inputAttemptCount)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NOT_INTEGER_INPUT.getMessage());
    }

    @Test
    void 사용자에게_빈값을_입력받을_시_예외를_던진다() {
        // given
        final String input = "\n";
        command(input);

        // when & then
        Assertions.assertThatThrownBy(InputView::inputCarNames)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BLANK_INPUT.getMessage());
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
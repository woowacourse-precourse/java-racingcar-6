package racingcar.view;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ConsoleTest {

    @Test
    void 자동차_이름_입력이_null일경우_예외를_발생한다() {
        // given
        Input fakeInput = () -> null;
        Console console = new Console(fakeInput, new PrintStreamOutput());

        // when, then
        assertThatThrownBy(console::readCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력이_null이_아닐_경우_예외를_발생하지_않는다() {
        // given
        Input fakeInput = () -> "a,b,c";
        Console console = new Console(fakeInput, new PrintStreamOutput());

        // when, then
        assertThatNoException().isThrownBy(console::readCarNames);
    }

    @ParameterizedTest(name = "{index}번째 Input")
    @MethodSource("wrongInputs")
    void 사용자_횟수_입력이_올바르지_못할_경우_예외를_발생한다(Input wrongInput) {
        // given
        Console console = new Console(wrongInput, new PrintStreamOutput());

        // when, then
        assertThatThrownBy(console::readNumberOfTrials)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index}번째 Input")
    @MethodSource("correctInputs")
    void 사용자_횟수_입력이_숫자일_경우_예외를_발생하지_않는다(Input correctInput) {
        // given
        Console console = new Console(correctInput, new PrintStreamOutput());

        // when, then
        assertThatNoException().isThrownBy(console::readNumberOfTrials);
    }

    static Stream<Input> wrongInputs() {
        return Stream.of(
                () -> "Not a number",
                () -> " ",
                () -> "",
                () -> null,
                () -> "a",
                () -> "1.1",
                () -> "1.0",
                () -> "-1",
                () -> "-100",
                () -> "-111"
        );
    }

    static Stream<Input> correctInputs() {
        return Stream.of(
                () -> "0",
                () -> "1",
                () -> "2",
                () -> "100",
                () -> "111"
        );
    }

}

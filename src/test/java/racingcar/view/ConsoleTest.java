package racingcar.view;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

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

}

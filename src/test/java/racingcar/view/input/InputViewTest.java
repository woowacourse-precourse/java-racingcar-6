package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @Test
    @DisplayName("경주할 자동차 이름들을 쉼표로 구분하며 입력할 수 있다.")
    void inputCarNames() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("tobi,ship,chan"));

        // when
        List<String> carNames = inputView.names();

        // then
        assertThat(carNames).isEqualTo(List.of("tobi", "ship", "chan"));
    }

    @Test
    @DisplayName("경주를 시도할 횟수를 입력할 수 있다.")
    void inputNumberOfAttempts() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("12"));

        // when
        long numberOfAttempts = inputView.number();

        // then
        Assertions.assertThat(numberOfAttempts).isEqualTo(12);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값은 예외를 던진다.")
    @ValueSource(strings = {"1@", "2d424", "가나"})
    void inputErrorWithNumberOfAttempts(String given) {
        // given
        InputView inputView = new InputView(new DoubleConsoleService(given));

        // when // then
        assertThatThrownBy(inputView::number)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION);
    }
}

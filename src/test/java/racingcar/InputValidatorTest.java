package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.CarNameInputValidator;
import racingcar.validator.RaceRoundInputValidator;

class InputValidatorTest {

    @DisplayName("자동차 이름이 5글자 이하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void carName(String name) {
        CarNameInputValidator validator = new CarNameInputValidator();
        assertThatCode(() -> validator.validateInput(name)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5글자 이하가 아니면 IllegalArgumentException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg"})
    void carNameException(String name) {
        CarNameInputValidator validator = new CarNameInputValidator();
        assertThatThrownBy(() -> validator.validateInput(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스 라운드가 숫자면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "10000"})
    void coin(String round) {
        RaceRoundInputValidator validator = new RaceRoundInputValidator();
        assertThatCode(() -> validator.validateInput(round)).doesNotThrowAnyException();
    }

    @DisplayName("레이스 라운드가 숫자가 아니면 IllegalArgumentException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "1a", "c3"})
    void coinException(String round) {
        RaceRoundInputValidator validator = new RaceRoundInputValidator();
        assertThatThrownBy(() -> validator.validateInput(round))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
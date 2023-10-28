package racingcar.validatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputNumberOfGameValidator;

public class InputNumberOfGameValidatorTest {
    private InputNumberOfGameValidator inputNumberOfGameValidator;

    @BeforeEach
    public void initInputNumberOfGameValidator() {
        inputNumberOfGameValidator = new InputNumberOfGameValidator();
    }

    @DisplayName("올바른 게임횟수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2", "3", "4", "5", "10", "14", "20"})
    void 올바른_게임횟수_테스트(String numberOfGames) {
        assertThatCode(() -> inputNumberOfGameValidator.validateNumberOfGame(numberOfGames)).doesNotThrowAnyException();
    }

    @DisplayName("게임횟수가 숫자가 아닌경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "#", "12a", "11@,"})
    void 게임횟수가_숫자가_아닌경우_테스트(String numberOfGames) {
        assertThat(inputNumberOfGameValidator.isNotDigit(numberOfGames)).isTrue();
    }

    @DisplayName("게임횟수가 0으로 시작하는경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "012", "0123"})
    void 게임횟수가_0으로시작하는경우_테스트(String numberOfGames) {
        assertThat(inputNumberOfGameValidator.startWithZero(numberOfGames)).isTrue();
    }

    @DisplayName("게임횟수가 음수인경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-4"})
    void 게임횟수가_음수인경우_테스트(String numberOfGames) {
        assertThat(inputNumberOfGameValidator.isNegativeNum(numberOfGames)).isTrue();
    }
}

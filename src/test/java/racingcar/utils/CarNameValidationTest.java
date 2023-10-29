package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameValidationTest {

    private CarNameValidation carNameValidation;

    @BeforeEach
    void setUp() {
        carNameValidation = new CarNameValidation();
    }

    @DisplayName("사용자가 자동차명을 5글자를 초과하여 입력했을 때, 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(strings = {"pobidd", "pobibb", "pobiee", "pobirr,bbbbooo"})
    void validateUserInput5CharacterTest(String inputCarName) {
        // given & when & then
        assertThatThrownBy(
                () -> carNameValidation.validateUserInput(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자를 초과하는 이름은 입력할 수 없습니다.");
    }

    @DisplayName("사용자가 자동차명에 숫자를 입력했을 때, 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(strings = {"pob1", "12", "bbo32", "123,pob1"})
    void validateUserInputNumber(String inputCarName) {
        // given & when & then
        assertThatThrownBy(
                () -> carNameValidation.validateUserInput(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 숫자가 들어갈 수 없습니다.");
    }

    @DisplayName("사용자가 자동차명을 입력하지 않았을 때, 예외를 발생하는지")
    @Test
    void validateUserInputBlank() {
        // given
        String inputCarName = "";

        // when & then
        assertThatThrownBy(
                () -> carNameValidation.validateUserInput(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 존재하지 않습니다.");
    }

    @DisplayName("사용자가 자동차명에 공백을 입력했을 때, 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "woni,pobi ", "woni, pobi"})
    void validateUserInputWhiteSpace(String inputCarNames) {
        // given & when & then
        assertThatThrownBy(
                () -> carNameValidation.validateUserInput(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 입력할 수 없습니다.");
    }
}
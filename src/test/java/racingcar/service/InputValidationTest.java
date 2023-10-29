package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("사용자가 자동차명을 5글자를 초과하여 입력했을때 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(strings = {"pobidd", "pobibb", "pobiee", "pobirr,bbbbooo"})
    void validateUserInput5CharacterTest(String inputCarName) {
        // given & when & then
        assertThatThrownBy(
                () -> inputValidation.validateUserInput(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자를 초과하는 이름은 입력할 수 없습니다.");
    }

    @DisplayName("사용자가 자동차명에 숫자를 입력했을 때, 예외를 발생하는지")
    @ParameterizedTest
    @ValueSource(strings = {"pob1", "12", "bbo32", "123,pob1"})
    void validateUserInputNumber(String inputCarName) {
        // given & when & then
        assertThatThrownBy(
                () -> inputValidation.validateUserInput(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 숫자가 들어갈 수 없습니다.");
    }

    @DisplayName("사용자가 이동 횟수에 아무것도 입력하지 않았을 때, 예외를 발생하는지")
    @ParameterizedTest
    @NullSource
    void validateMovementNullTest(Integer movement) {
        // given & when & then
        assertThatThrownBy(
                () -> inputValidation.validateMovement(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요");
    }
}
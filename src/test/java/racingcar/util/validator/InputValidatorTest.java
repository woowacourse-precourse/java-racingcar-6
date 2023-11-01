package racingcar.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("InputValidator Test")
public class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름 입력 테스트 - 아무 것도 입력하지 않았을 경우")
    void checkCarNameInputValidationTest_Empty() {
        // Given
        List<String> inputCarNameList = List.of();

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkCarNameInputValidation(inputCarNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하지 않았습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 자동차 이름이 5자를 초과한 경우")
    void checkCarNameInputValidationTest_CarLengthOverFive() {
        // Given
        List<String> inputCarNameList = List.of("overFive", "pobi");

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkCarNameInputValidation(inputCarNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과합니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 자동차 이름을 중복해서 입력한 경우")
    void checkCarNameInputValidationTest_Duplicated() {
        // Given
        List<String> inputCarNameList = List.of("pobi", "pobi", "woni");

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkCarNameInputValidation(inputCarNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복으로 입력되었습니다.");
    }

    @Test
    @DisplayName("시도 회수 입력 테스트 - 입력하지 않은 경우")
    void checkTryCountInputValidationTest_Empty() {
        // Given
        String inputTryCount = "";

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수를 입력하지 않았습니다.");
    }

    @Test
    @DisplayName("시도 회수 입력 테스트 - 숫자가 아닌 값을 입력했을 경우")
    void checkTryCountInputValidationTest_Wrong() {
        // Given
        String inputTryCount = "tryCount";

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("시도 회수 입력 테스트 - 음수를 입력했을 경우")
    void checkTryCountInputValidationTest_Range() {
        // Given
        String inputTryCount = "-3";

        // When & Then
        assertThatThrownBy(() -> InputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 값을 입력하지 않았습니다.");
    }
}

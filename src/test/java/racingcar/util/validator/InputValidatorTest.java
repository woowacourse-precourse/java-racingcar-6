package racingcar.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    @DisplayName("[InputValidatior] 자동차 이름이 입력되지 않았을 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkCarNameInputValidation_CarNameListEmpty() {
        // Given
        InputValidator inputValidator = new InputValidator();
        List<String> carNameList = List.of();

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkCarNameInputValidation(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하지 않았습니다.");
    }

    @Test
    @DisplayName("[InputValidatior] 자동차 이름이 5자 이상일 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkCarNameInputValidation_LengthOverFive() {
        // Given
        InputValidator inputValidator = new InputValidator();
        List<String> carNameList = List.of("pobijun", "pobi");

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkCarNameInputValidation(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과합니다.");
    }

    @Test
    @DisplayName("[InputValidatior] 자동차 이름이 중복일 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkCarNameInputValidation_Duplicate() {
        // Given
        InputValidator inputValidator = new InputValidator();
        List<String> carNameList = List.of("pobi", "pobi");

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkCarNameInputValidation(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복으로 입력되었습니다.");
    }

    @Test
    @DisplayName("[InputValidatior] 시도 회수가 입력되지 않았을 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkTryCountInputValidation_Empty() {
        // Given
        InputValidator inputValidator = new InputValidator();
        String inputTryCount = "";

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수를 입력하지 않았습니다.");
    }

    @Test
    @DisplayName("[InputValidatior] 시도 회수에 숫자가 아닌 값을 입력했을 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkTryCountInputValidation_Wrong() {
        // Given
        InputValidator inputValidator = new InputValidator();
        String inputTryCount = "r";

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("[InputValidatior] 시도 회수에 1보다 작은 값을 입력했을 때 `IllegalArgumentException`을 발생시킨 후 종료한다.")
    void checkTryCountInputValidation_Wrong_Range() {
        // Given
        InputValidator inputValidator = new InputValidator();
        String inputTryCount = "-3";

        // When & Then
        assertThatThrownBy(() -> inputValidator.checkTryCountInputValidation(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 값을 입력하지 않았습니다.");
    }
}

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidationTest {

    @DisplayName("시도횟수 입력이 숫자가 아닌 경우 테스트")
    @Test
    void validateTryInputNumberTest() {
        String tryInput = "e";
        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> {
            inputValidation.tryInputNumberValidate(tryInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

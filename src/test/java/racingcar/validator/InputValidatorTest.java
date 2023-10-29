package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차 이름이 비어있을 경우 예외가 발생한다.")
    @Test
    void validateCarNameEmptyOrNull() {
        // given
        String names = "";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateCarNameEmptyOrNull(names))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
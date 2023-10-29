package validatorTest;

import static enums.ErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import enums.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.StringLengthValidator;

public class StringLengthValidatorTest {

    @ParameterizedTest
    @DisplayName("유효한 문자열있때 true 반환")
    @ValueSource(strings = {"name", "hoon", "jihoo"})
    void validateMaxLength_true_Test(String value) {
        //when
        boolean result = StringLengthValidator.validateMaxLength(value);

        //then
        assertThat(result).isTrue();
    }


    @ParameterizedTest
    @DisplayName("유효하지 않은 문자열 길이일 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"wrongName", "longName", "taehoon"})
    void validateMaxLength_ThrowException_Test(String value) {
        assertThatThrownBy(() -> StringLengthValidator.validateMaxLength(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MAX_LENGTH_ERROR.getMessage());
    }
}

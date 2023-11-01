package utils.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.message.ErrorMessage;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserInputValidationTest {
    @ParameterizedTest
    @DisplayName("숫자로 변환할때 숫자가 아닌 값 입력 시 예외처리")
    @ValueSource(strings = {"a", "b", "&", "!"})
    public void 숫자변환시_숫자가아닌값입력시_예외처리(String value) {
        // when
        Throwable exception = catchThrowable(() -> UserInputValidation.checkNumber(value));
        
        // then
        Assertions.assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ROUND_CNT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자로 변환 시 정상적인 숫자 값 입력했을 경우")
    @ValueSource(strings = {"1", "2", "11", "200"})
    public void 숫자변환시_정상적인_숫자_입력했을경우(String value) {
        // then
        assertDoesNotThrow(() -> UserInputValidation.checkNumber(value));

    }
}

package racingcar.Validator;

import static racingcar.Message.CarNameExceptionPrompt.DUPLICATEMESSAGE;
import static racingcar.Message.CarNameExceptionPrompt.LENGTHMESSAGE;
import static racingcar.Message.CarNameExceptionPrompt.WHITESPACEMESSAGE;
import static racingcar.Validator.CarNameValidator.hasDuplicateName;
import static racingcar.Validator.CarNameValidator.hasWhiteSpace;
import static racingcar.Validator.CarNameValidator.isValidLength;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    @DisplayName("자동차 이름 길이 검증 테스트")
    void isValidLengthTest() {
        String testCarName = "test";

        Assertions.assertThatThrownBy(() -> isValidLength(testCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTHMESSAGE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는지 검증 테스트")
    void hasWhiteSpaceTest() {
        String testCarName = "test test";

        Assertions.assertThatThrownBy(() -> hasWhiteSpace(testCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WHITESPACEMESSAGE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는지 검증 테스트")
    void hasDuplicateNameTest() {
        List<String> testCarGroup = List.of("test", "test");

        Assertions.assertThatThrownBy(() -> hasDuplicateName(testCarGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATEMESSAGE.getMessage());
    }
}
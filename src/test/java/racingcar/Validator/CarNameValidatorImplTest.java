package racingcar.Validator;

import static racingcar.Message.CarNameExceptionPrompt.DUPLICATEMESSAGE;
import static racingcar.Message.CarNameExceptionPrompt.LENGTHMESSAGE;
import static racingcar.Message.CarNameExceptionPrompt.WHITESPACEMESSAGE;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorImplTest {

    private final CarNameValidatorImpl carNameValidatorImpl = new CarNameValidatorImpl();

    @Test
    @DisplayName("자동차 이름 길이 검증 테스트")
    void isValidLengthTest() {
        String testCarName1 = "test123";
        String testCarName2 = "test123";

        Assertions.assertThatThrownBy(() -> carNameValidatorImpl.isValidLength(testCarName1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTHMESSAGE.getMessage(testCarName1));

        Assertions.assertThatThrownBy(() -> carNameValidatorImpl.isValidLength(testCarName2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTHMESSAGE.getMessage(testCarName2));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는지 검증 테스트")
    void hasWhiteSpaceTest() {
        String testCarName = "test test";

        Assertions.assertThatThrownBy(() -> carNameValidatorImpl.hasWhiteSpace(testCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WHITESPACEMESSAGE.getMessage(testCarName));
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는지 검증 테스트")
    void hasDuplicateNameTest() {
        String testCarName1 = "test1";
        String testCarName2 = "test2";

        List<String> testCarGroup1 = List.of(testCarName1, testCarName1);
        List<String> duplicateCarNames1 = List.of(testCarName1);

        List<String> testCarGroup2 = List.of(testCarName1, testCarName1, testCarName2, testCarName2);
        List<String> duplicateCarNames2 = List.of(testCarName1, testCarName2);

        Assertions.assertThatThrownBy(() -> carNameValidatorImpl.hasDuplicateName(testCarGroup1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATEMESSAGE.getMessage(duplicateCarNames1.toString()));

        Assertions.assertThatThrownBy(() -> carNameValidatorImpl.hasDuplicateName(testCarGroup2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATEMESSAGE.getMessage(duplicateCarNames2.toString()));
    }
}
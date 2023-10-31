package jalddak.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.ErrorMessage.BLANK;
import static racingcar.validator.ErrorMessage.DUPLICATE;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.NOT_INTEGER;
import static racingcar.validator.InputValidator.validateDuplicateName;
import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateLenOfCarName;
import static racingcar.validator.InputValidator.validateName;
import static racingcar.validator.InputValidator.validateRangeOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 에외테스트_validateName() {
        List<String> givenList = new ArrayList<>();
        givenList.add(",,,,,a,,,");
        givenList.add("a,     ,     ,");
//        givenList.add("a,,,,");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateName(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BLANK.getMessage());
        }
    }

    @Test
    void 예외테스트_validateDuplicateName() {
        List<String> givenList = new ArrayList<>();
        givenList.add("a,b,c,d,e,a");
        givenList.add("a,a,a");
//        givenList.add("a,b,c,d,e");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateDuplicateName(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(DUPLICATE.getMessage());
        }
    }

    @Test
    void 예외테스트_validateLenOfCar() {
        List<String> givenList = new ArrayList<>();
        givenList.add("a,,,,");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateLenOfCar(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
        }
    }

    @Test
    void 예외테스트_validateLenOfCarName() {
        List<String> givenList = new ArrayList<>();
        givenList.add("asdasd");
        givenList.add("   s  ");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateLenOfCarName(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
        }
    }

    @Test
    void 예외테스트_validateStringToInteger() {
        List<String> givenList = new ArrayList<>();
        givenList.add("");
        givenList.add("asd");
        givenList.add("31sda");
//        givenList.add("123141");
        givenList.add("2147483648");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateStringToInteger(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_INTEGER.getMessage());
        }
    }

    @Test
    void 예외테스트_validateRangeOfMatches() {
        List<String> givenList = new ArrayList<>();
//        givenList.add("123141");
        givenList.add("0");
//        givenList.add("1");
//        givenList.add("2147483647");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateRangeOfMatches(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LESS_THAN_MIN_NUM_OF_MATCHES.getMessage());
        }

    }
}

package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    @DisplayName("입력받은 자동차이름이 5글자를 넘을 경우 IllegalArgumentException을 처리한다")
    void throw_IllegalArgumentException_when_inputCarName_isLongerThan_5() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> userInputValidator.carNameIsValid("carname"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.carNameIsValid("carname,123456"));
    }

    @Test
    @DisplayName("정상적으로 자동차입력을 받았을 경우 true반환")
    void true_return_when_inputCarName_is_normal() {

        Assertions.assertTrue(() -> userInputValidator.carNameIsValid("12345"));
        Assertions.assertTrue(() -> userInputValidator.carNameIsValid("12345,pobi"));
    }

    @Test
    @DisplayName("한국어나 특수문자로 자동차이름을 입력받아도 true반환")
    void return_true_when_inputCarName_is_korAndSpecialChar() {

        Assertions.assertTrue(() -> userInputValidator.carNameIsValid("한글과!차"));
        Assertions.assertTrue(() -> userInputValidator.carNameIsValid("!](,"));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있어면 제거하여 조건에 맞으면 true반환")
    void return_true_when_inputCarName_hasBlank() {

        Assertions.assertTrue(() -> userInputValidator.carNameIsValid("안 녕 하 세 요 "));
    }


    // TODO: 시도할 회수가 숫자가 아닌지 체크
    @Test
    @DisplayName("0이나 문자를 입력했을 때 IllegalArgumentException 처리")
    void throw_IllegalArgumentException_when_inputCarName_is_not_num() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> userInputValidator.attemptCountIsValid("다섯번"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userInputValidator.attemptCountIsValid("five"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userInputValidator.attemptCountIsValid("0"));
    }

    @Test
    @DisplayName("정상적인 시도 횟수를 입력하면 true 반환")
    void return_true_when_attemptCount_isValid() {

        Assertions.assertTrue(() -> userInputValidator.attemptCountIsValid("12"));
    }

}

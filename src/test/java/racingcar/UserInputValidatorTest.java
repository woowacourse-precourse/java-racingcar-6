package racingcar;

import static racingcar.UserInputValidator.attemptCountIsValid;
import static racingcar.UserInputValidator.carNameIsValid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserInputValidatorTest {


    @Test
    @DisplayName("입력받은 자동차이름이 5글자를 넘을 경우 IllegalArgumentException을 처리한다")
    void throw_IllegalArgumentException_when_inputCarName_isLongerThan_5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid("carname"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid("carname,123456"));
    }

    @Test
    @DisplayName("정상적으로 자동차입력을 받았을 경우 true반환")
    void true_return_when_inputCarName_is_normal() {
        Assertions.assertTrue(() -> carNameIsValid("12345,pobi"));
    }

    @Test
    @DisplayName("한국어나 특수문자로 자동차이름을 입력받아도 true반환")
    void return_true_when_inputCarName_is_korAndSpecialChar() {
        Assertions.assertTrue(() -> carNameIsValid("한글과!차,en!@굳"));
        Assertions.assertTrue(() -> carNameIsValid("!](,오"));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있어면 제거하여 조건에 맞으면 true반환")
    void return_true_when_inputCarName_hasBlank() {
        Assertions.assertTrue(() -> carNameIsValid("안 녕 하 세 요 , 반 갑 습 1"));
    }

    @Test
    @DisplayName("빈칸이나 null값 전달하면 예외처리")
    void throw_IllegalException_when_inputCarName_isNullOrBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(" "));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(null));
    }

    @Test
    @DisplayName("자동차를 한대만 입력했다면 예외처리")
    void throw_when_input_only_one_carName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid("java"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid("java,"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(",java"));
    }

    // 시도할 회수가 숫자가 아닌지 체크
    @Test
    @DisplayName("0이나 문자를 입력했을 때 IllegalArgumentException 처리")
    void throw_IllegalArgumentException_when_inputCarName_is_not_num() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid("다섯번"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid("five"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid("0"));
    }

    @Test
    @DisplayName("정상적인 시도 횟수를 입력하면 true 반환")
    void return_true_when_attemptCount_isValid() {
        Assertions.assertTrue(() -> attemptCountIsValid("12"));
    }

    @Test
    @DisplayName("10_000이상을 입력하면 IllegalArgumentException 처리")
    void throw_when_input_1000() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid("10000"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid("100_000_000_000"));
    }

}

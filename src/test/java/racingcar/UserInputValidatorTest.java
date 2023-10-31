package racingcar;

import static racingcar.UserInputValidator.attemptCountIsValid;
import static racingcar.UserInputValidator.carNameIsValid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UserInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"carname", "carname,123456"})
    @DisplayName("입력받은 자동차이름이 5글자를 넘을 경우 IllegalArgumentException을 처리한다")
    void throw_IllegalArgumentException_when_inputCarName_isLongerThan_5(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(name));
    }

    @Test
    @DisplayName("정상적으로 자동차입력을 받았을 경우 true반환")
    void true_return_when_inputCarName_is_normal() {
        Assertions.assertTrue(() -> carNameIsValid("12345,pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글과!차,en!@굳", "!](,오"})
    @DisplayName("한국어나 특수문자로 자동차이름을 입력받아도 true반환")
    void return_true_when_inputCarName_is_korAndSpecialChar(String name) {
        Assertions.assertTrue(() -> carNameIsValid(name));
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

    @ParameterizedTest
    @ValueSource(strings = {"java", "java,", ",java"})
    @DisplayName("자동차를 한대만 입력했다면 예외처리")
    void throw_when_input_only_one_carName(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameIsValid(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"다섯번", "five", "0"})
    @DisplayName("0이나 문자를 입력했을 때 IllegalArgumentException 처리")
    void throw_IllegalArgumentException_when_inputCarName_is_not_num(String count) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid(count));
    }

    @Test
    @DisplayName("정상적인 시도 횟수를 입력하면 true 반환")
    void return_true_when_attemptCount_isValid() {
        Assertions.assertTrue(() -> attemptCountIsValid("12"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000", "100_000_000_000"})
    @DisplayName("10_000이상을 입력하면 IllegalArgumentException 처리")
    void throw_when_input_1000(String count) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptCountIsValid(count));
    }

}

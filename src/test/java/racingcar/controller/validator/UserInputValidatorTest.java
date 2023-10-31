package racingcar.controller.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    @DisplayName("자동차이름: 정상 입력")
    public void correctInput() {
        String rawInput = "A";

        userInputValidator.validateCarNames(rawInput);
    }

    @Test
    @DisplayName("자동차이름: 정상 입력")
    public void correctInput2() {
        String rawInput = "A,B,C";

        userInputValidator.validateCarNames(rawInput);
    }

    @Test
    @DisplayName("자동차이름: 정상 중복 허용")
    public void correctInput3() {
        String rawInput = "A,B,B";

        userInputValidator.validateCarNames(rawInput);
    }

    @Test
    @DisplayName("자동차이름: ,사이 이름 없음")
    public void wrongInput() {
        String rawInput = ",,,";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름: ,사이 이름 없음2")
    public void wrongInput2() {
        String rawInput = "A,,,B";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름: 마지막이 ,로 끝나는 문자열")
    public void wrongInput3() {
        String rawInput = "A,B,";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름: 처음이 ,로 시작하는 문자열")
    public void wrongInput4() {
        String rawInput = ",A,B";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("자동차이름: 다섯 글자가 넘는 이름")
    public void wrongInput5() {
        String rawInput = "ABCDEFG";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("이동 횟수: 정상 입력")
    public void moveCountCorrectInput() {
        String number = "5";

        userInputValidator.validateRoundCount(number);
    }

    @Test
    @DisplayName("이동 횟수: 정상 입력2")
    public void moveCountCorrectInput2() {
        String number = "0";

        userInputValidator.validateRoundCount(number);
    }

    @Test
    @DisplayName("이동 횟수: 숫자가 아닌 문자")
    public void moveCountWrongInput() {
        String number = "A";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateRoundCount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수: 음수")
    public void moveCountWrongInput2() {
        String number = "-5";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateRoundCount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
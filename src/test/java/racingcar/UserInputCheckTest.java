package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputCheckTest extends NsTest {
    UserInputCheck userInputCheck = new UserInputCheck();

    @Test
    @DisplayName("자동차 이름 길이 유효한 경우")
    void checkNameLengthTest_validInput() {
        String validInput = "pobi,woni,jun";
        assertDoesNotThrow(() -> userInputCheck.checkNameLength(validInput));
    }

    @Test
    @DisplayName("자동차 이름 길이 유효하지 않은 경우")
    public void checkNameLengthTest_invalidInput() {
        String invalidInput = "pobidi,woni,jun";
        assertThatThrownBy(() -> userInputCheck.checkNameLength(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.NOT_LENGTH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("시도 횟수 숫자 입력 유효한 경우")
    void checkNumberTest_validInput() {
        String validInput = "10";
        assertDoesNotThrow(() -> userInputCheck.checkNumber(validInput));
    }

    @Test
    @DisplayName("시도 횟수 숫자 입력 유효하지 않은 경우")
    void checkNumberTest_invalidInput() {
        String invalidInput = "문자";
        assertThatThrownBy(() -> userInputCheck.checkNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.NOT_NUMBER_ERROR_MESSAGE);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

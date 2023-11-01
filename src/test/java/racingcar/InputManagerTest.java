package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputManagerTest {
    @Test
    void throw_exception_for_invalid_car_name_length() {
        InputManager inputManager = new InputManager();

        String invalidName = "abcdef";

        assertThatThrownBy(() -> inputManager.isValidName(invalidName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({"-1, 시도 횟수는 음수가 될 수 없습니다.", "abc, 문자는 입력할 수 없습니다."})
    void throw_exception_for_invalid_try_count(String invalidNum, String expectedMessage) {
        InputManager inputManager = new InputManager();

        assertThatThrownBy(() -> inputManager.isValidNum(invalidNum))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(expectedMessage);
    }
}

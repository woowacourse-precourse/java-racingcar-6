package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputManagerTest {
    @Test
    void throw_exception_for_invalid_car_name_length() {
        InputManager inputManager = new InputManager();

        String invalidName = "abcdef";

        assertThatThrownBy(() -> inputManager.isValidName(invalidName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}

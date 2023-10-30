package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputManagerTest {
    InputManager inputManager = new InputManager();

    @Test
    public void 숫자가_아닌_수_입력() {
        String notInteger = "가나다라";
        Assertions.assertThatThrownBy(() -> inputManager.inputNumber(notInteger))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
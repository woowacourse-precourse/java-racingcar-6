package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputManagerTest {
    InputManager inputManager = new InputManager();

    @Test
    public void 시도횟수_정상입력() {
        String notInteger = "12";
        InputStream in = new ByteArrayInputStream(notInteger.getBytes());
        System.setIn(in);
    }

    @Test
    public void 시도횟수_문자입력() {
        String notInteger = "가나다라";
        InputStream in = new ByteArrayInputStream(notInteger.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputManager.number())
                .isInstanceOf(IllegalArgumentException.class);

    }

}
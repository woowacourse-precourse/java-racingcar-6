package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class InputManagerTest {
    @BeforeEach
    public void setup() {
        Console.close();
    }

    @Test
    void 시행_입력_예외처리() {
        setInput("1d");
        assertThrowsExactly(IllegalArgumentException.class, InputManager.INPUT_MOVE_COUNT::input);
    }

    @Test
    void 이름_입력_예외처리() {
        setInput("김희겸,신예찬,엄성준,김현진ㅇㅇㅇ");
        assertThrowsExactly(IllegalArgumentException.class, InputManager.INPUT_NAME::input);
    }

    @Test
    void 이름_입력() {
        setInput("김희겸,신예찬,엄성준,김현진");
        List<String> inputs = (List<String>) InputManager.INPUT_NAME.input();
        assertThat(inputs).containsExactly("김희겸", "신예찬", "엄성준", "김현진");
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
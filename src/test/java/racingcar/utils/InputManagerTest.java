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
    void 시행_입력_예외처리_숫자가_아닌_입력() {
        setInput("1d");
        assertThrowsExactly(IllegalArgumentException.class, GameCountInputManager.getInstance()::input);
    }

    @Test
    void 시행_입력_예외처리_음수_입력() {
        setInput("-1");
        assertThrowsExactly(IllegalArgumentException.class, GameCountInputManager.getInstance()::input);
    }

    @Test
    void 이름_입력_예외처리_5자_이상의_이름() {
        setInput("김희겸,신예찬,엄성준,김현진ㅇㅇㅇ");
        assertThrowsExactly(IllegalArgumentException.class, UsernameInputManager.getInstance()::input);
    }
    @Test
    void 이름_입력_예외처리_0명() {
        setInput(",,,,");
        assertThrowsExactly(IllegalArgumentException.class, UsernameInputManager.getInstance()::input);
    }

    @Test
    void 이름_입력() {
        setInput("김희겸,신예찬,엄성준,김현진");
        List<String> inputs = (List<String>) UsernameInputManager.getInstance().input();
        assertThat(inputs).containsExactly("김희겸", "신예찬", "엄성준", "김현진");
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
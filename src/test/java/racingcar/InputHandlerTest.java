package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    private static final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름을 정상적으로 입력하는 경우")
    void inputCarNamesTest1() {
        setInput("pobi,woni,jun\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {"pobi", "woni", "jun"};
        Assertions.assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름 중 공백을 포함하여 입력하는 경우")
    void inputCarNamesTest2() {
        setInput("pobi, woni, jun\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {"pobi", " woni", " jun"}; // 공백 처리는 Validator에서 진행한다.
        Assertions.assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름 중 공백만을 입력하는 경우")
    void inputCarNamesTest3() {
        setInput("\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {""}; // 예외 처리는 Validator에서 진행한다.
        Assertions.assertThat(carNames).isEqualTo(expected);
    }

    void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
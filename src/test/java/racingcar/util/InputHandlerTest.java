package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름을 정상적으로 입력하는 경우")
    void inputCarNamesTest1() {
        setInput("pobi,woni,jun\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {"pobi", "woni", "jun"};
        assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름 중 공백을 포함하여 입력하는 경우")
    void inputCarNamesTest2() {
        setInput("pobi, woni, jun\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {"pobi", " woni", " jun"}; // 공백 처리는 Validator에서 진행한다.
        assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름 중 공백만을 입력하는 경우")
    void inputCarNamesTest3() {
        setInput("\n");
        String[] carNames = InputHandler.inputCarNames();
        String[] expected = {""}; // 예외 처리는 Validator에서 진행한다.
        assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("정상적인 자동차 이름 입력")
    void makeCarNamesArrayTest1() {
        setInput("pobi,wons,jun,park\n");
        String[] carNamesArray = InputHandler.makeCarNamesArray();
        String[] expectedCarNamesArray = {"pobi", "wons", "jun", "park"};
        assertThat(carNamesArray).isEqualTo(expectedCarNamesArray);
    }

    @Test
    @DisplayName("잘못된 자동차 이름 입력 시, 예외 발생")
    void makeCarNamesArrayTest2() {
        setInput("pobi,wonians,jun\n");
        assertThatThrownBy(() -> InputHandler.makeCarNamesArray())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
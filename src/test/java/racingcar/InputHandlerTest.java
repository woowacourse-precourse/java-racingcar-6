package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    @DisplayName("자동차 이름을 정상적으로 입력하는 경우")
    void parseCarNameTest1() {
        String rawCarNames = "pobi,woni,jun";
        String[] carNames = InputHandler.parseCarName(rawCarNames);
        String[] expected = {"pobi", "woni", "jun"};

        Assertions.assertThat(carNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름 중 공백을 입력하는 경우")
    void parseCarNameTest2() {
        String rawCarNames = "pobi, woni, jun";
        String[] carNames = InputHandler.parseCarName(rawCarNames);
        String[] expected = {"pobi", " woni", " jun"}; // 공백 처리는 Validator에서 진행한다.

        Assertions.assertThat(carNames).isEqualTo(expected);
    }
}
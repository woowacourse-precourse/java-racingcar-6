package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.Input.InputParser;

public class InputParserTest {
    @Test
    @DisplayName("예외 처리 : 자동차")
    void inputString_exception() {
       String input = "BMW, Audi, Tesla";
        InputParser inputParser = new InputParser();
        inputParser.parseCarString(input);
    }
}

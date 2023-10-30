package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    @DisplayName("예외 처리 : 자동차")
    void inputString_exception() {
       String input = "BMW, Audi, Tesla";
        InputParser inputParser = new InputParser();
        inputParser.parseCarString(input);
    }

    @Test
    @DisplayName("예외 처리 : 자동차List")
    void Cars() {
        String input = "BMW, Audi, Tesla";
        InputView inputView = new InputView(new InputParser());
        inputView.inputCarName();
    }
}

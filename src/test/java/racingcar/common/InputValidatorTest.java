package racingcar.common;

import racingcar.common.Converter;
import racingcar.common.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 자동차_이름_검증_테스트(){
        InputValidator inputValidator = new InputValidator();
        String input = "test,";
        Map<String, Integer> cars = Converter.stringToMap(input);

        assertThatThrownBy(() -> inputValidator.carNameValidator(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임횟수_검증_음수일시_예외발생_테스트(){
        int input = -1;
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.gameCountValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

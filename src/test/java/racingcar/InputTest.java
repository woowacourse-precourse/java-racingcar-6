package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    void 자동차_이름_검증_테스트(){
        Converter converter = new Converter();
        InputValidator inputValidator = new InputValidator();
        String input = "test,";
        Map<String, Integer> cars = converter.stringToMap(input);

        assertThatThrownBy(() -> inputValidator.carNameValidator(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임횟수_검증_테스트(){
        String input = "1번";
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.gameCountValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

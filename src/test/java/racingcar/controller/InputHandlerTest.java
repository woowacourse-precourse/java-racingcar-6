package racingcar.controller;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest{

    @Test
    void parseCarName_테스트() {
        String input = "pobi,woni,jun";
        List<String> carNames = InputHandler.parseCarName(input);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"","pobi,javaji"})
    void parseCarName_예외_처리(String input) {
        assertThatThrownBy(() -> InputHandler.parseCarName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void triesCount_테스트() {
        String input = "5";
        int tries = InputHandler.triesCount(input);
        assertThat(tries).isEqualTo(5);
    }

    @Test
    void triesCount_예외_처리() {
        String input = "seven";
        assertThatThrownBy(() -> InputHandler.triesCount(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}

package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.wrapper.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"red", "green", "blue"})
    void validateCarName_성공_테스트(String input) {
        new CarName(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "yellow", "   "})
    void validateCarName_실패_테스트(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfMoveTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "fjk"})
    public void 유효하지_않은_이동횟수(String input) {
        //then
        assertThatThrownBy(() -> NumberOfMove.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfMoveTest {
    @ParameterizedTest
    @DisplayName("입력값의 유효성 테스트")
    @ValueSource(strings = {"", "-1", "fjk"})
    public void 유효하지_않은_이동횟수(String playerInput) {
        //then
        assertThatThrownBy(() -> NumberOfMove.create(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

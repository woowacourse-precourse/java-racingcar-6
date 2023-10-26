package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @DisplayName("4 이상의 값인지 판단한는 기능")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void checkValueIsOverFour_4이상_판단_기능(int value) {
        Position position = new Position();

        assertThat(position.checkValueIsOverFour(value)).isTrue();
    }
}

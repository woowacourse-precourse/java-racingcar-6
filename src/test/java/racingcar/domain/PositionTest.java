package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Position 테스트")
public class PositionTest {

    @Test
    @DisplayName("Position 객체 생성 및 이동 테스트")
    void createAndMovePosition() {
        int defaultPosition = 0;
        int increasePosition = defaultPosition + 1;

        Position position = new Position(defaultPosition);
        Position newPosition = position.move();

        assertThat(newPosition.position()).isEqualTo(increasePosition);
    }
}

package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    private Position position;

    @DisplayName("Car Position을 1만큼 증가시킨다.")
    @Test
    void increasePosition() {
        position = new Position(0);
        position.increase();
        Assertions.assertEquals(1, position.getCarPosition());
    }
}

package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarInformationTest {
    @Test
    void 움직임_확인() {
        CarInformation car = new CarInformation("pobi");
        int initialPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isBetween(initialPosition, initialPosition + 1);
    }
}
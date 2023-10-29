package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("MOVE의 값을 받았을 때")
    void move() {
        Car car = new Car("test");
        car.move(MoveCondition.MOVE);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("STOP의 값을 받았을 때")
    void stop() {
        Car car = new Car("test");
        car.move(MoveCondition.STOP);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void isWinner() {
        Car car = new Car("test");

        car.move(MoveCondition.MOVE);
        car.move(MoveCondition.MOVE);

        assertThat(car.isEqualToPosition(2)).isTrue();
    }
}
package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차가 전진하면, 자동차의 위치가 1 올라간다.")
    @Test
    void carMovesForwardThenPositionIncreasesByOne() {
        //Given
        Car car = new Car("pobi");

        //When
        car.move();

        //Then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
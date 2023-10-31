package study;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동자는_4이상의_숫자가_들어오면_전진한다() {
        // Given
        Car car = new Car("pobi");

        // When
        for (int randomNumber = 4; randomNumber <= 9; randomNumber++) {
            car.decideMoveOrNot(randomNumber);
        }

        // Then
        assertThat(car.getScore()).isEqualTo(6);
    }

    @Test
    void 자동차는_4미만의_숫자가_들어오면_움직이지_않는다() {
        // Given
        Car car = new Car("pobi");

        // When
        for (int randomNumber = 0; randomNumber < 4; randomNumber++) {
            car.decideMoveOrNot(randomNumber);
        }

        // Then
        assertThat(car.getScore()).isEqualTo(0);
    }
}

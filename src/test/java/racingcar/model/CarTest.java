package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void Car_tryToMove_정지_테스트() {
        // Given
        final Car car = new Car("hi");

        // When
        car.tryToMove(new NotMovableNumberGenerator());

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void Car_tryToMove_한칸_전진_테스트() {
        // Given
        final Car car = new Car("hi");

        // When
        car.tryToMove(new MovableNumberGenerator());

        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

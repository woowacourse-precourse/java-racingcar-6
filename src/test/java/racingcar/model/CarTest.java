package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 전진하면, 자동차의 위치값이 증가한다.")
    @Test
    void Given_Car_When_CarForward_Then_CarPositionIncrease() throws Exception {
        // Given
        int startingCarPosition = 0;
        int expectedCarPosition = 1;
        Car car = new Car(createBoundedRandomNumberGenerator(), "edgar", startingCarPosition);

        // When
        car.forward();
        int currentPosition = car.getStatus().position();

        // Then
        assertThat(currentPosition).isEqualTo(expectedCarPosition);
    }

    @DisplayName("자동차가 전진하지 않으면, 자동차의 위치값은 변하지 않는다.")
    @Test
    void Given_Car_When_CarNotForward_Then_CarPositionNotChange() throws Exception {
        // Given
        int startingCarPosition = 0;
        int expectedCarPosition = 0;
        Car car = new Car(createNotBoundedRandomNumberGenerator(), "edgar", startingCarPosition);

        // When
        car.forward();
        int currentPosition = car.getStatus().position();

        // Then
        assertThat(currentPosition).isEqualTo(expectedCarPosition);
    }

    private RandomNumberUtil createBoundedRandomNumberGenerator() {
        return new RandomNumberUtil() {
            @Override
            public int generateNumberInRange(int startNumber, int endNumber) {
                return 5;
            }
        };
    }

    private RandomNumberUtil createNotBoundedRandomNumberGenerator() {
        return new RandomNumberUtil() {
            @Override
            public int generateNumberInRange(int startNumber, int endNumber) {
                return 0;
            }
        };
    }
}

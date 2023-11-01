package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 주어진_값만큼_자동차_이동() {
        int distanceToMove = 10;

        Car car = new Car("test");
        car.move(distanceToMove);

        int result = car.getDistance();
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 주어진_값만큼_자동차_추가이동() {
        int distanceToMove1 = 10;
        Car car = new Car("test");

        car.move(distanceToMove1);
        assertThat(car.getDistance()).isEqualTo(10);

        int distanceToMove2 = 5;
        car.move(distanceToMove2);

        int result = car.getDistance();
        int expected = 15;
        assertThat(result).isEqualTo(expected);
    }
}

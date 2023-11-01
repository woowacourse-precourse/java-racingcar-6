package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car testCar = new Car("Car1");

    @Test
    void Car_생성자_테스트() {
        Car car = new Car("Car1");

        assertThat(car.getName()).isEqualTo("Car1");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void drive_메서드_사용_시_true일_때_position_1증가() {
        testCar.drive(true);

        assertThat(testCar.getPosition()).isEqualTo(1);
    }

    @Test
    void drive_메서드_사용_시_false일_때_position_변화_없음() {
        testCar.drive(false);

        assertThat(testCar.getPosition()).isEqualTo(0);
    }
}

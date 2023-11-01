package racingcar;

import car.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final String CAR_NAME = "레이싱카";
    private static final int CAR_INIT_POSITION = 0;


    @Test
    void Car_이름_가져오기() {
        Car car = new Car(CAR_NAME);

        String carName = car.getName();

        assertThat(CAR_NAME).isEqualTo(carName);
    }

    @Test
    void Car_위치_초기값_가져오기() {
        Car car = new Car(CAR_NAME);

        int carPosition = car.getPosition();

        assertThat(CAR_INIT_POSITION).isEqualTo(carPosition);
    }

    @Test
    void Car_이동하기() {
        Car car = new Car(CAR_NAME);

        int repeat = 3;

        for (int i = 0; i < repeat; i++) {
            car.move();
        }

        int carPosition = car.getPosition();

        assertThat(repeat).isEqualTo(carPosition);
    }
}

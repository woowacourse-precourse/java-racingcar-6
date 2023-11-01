package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void Car_생성_테스트() {
        Car car = new Car("car");
        assertThat(car).isNotNull();
    }

    @Test
    void Car_Position_변경_테스트() {
        Car car = new Car("car");
        assertThat(car.forwardPosition(3)).isEqualTo(0);
        assertThat(car.forwardPosition(5)).isEqualTo(1);

    }





}
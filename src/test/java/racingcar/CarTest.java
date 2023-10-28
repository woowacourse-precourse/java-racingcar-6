package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void Car_인스턴스_생성확인() {
        Car car = new Car("kim");
        assertThat(car.carName).isEqualTo("kim");
    }
}
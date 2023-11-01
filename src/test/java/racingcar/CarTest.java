package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 생성하기")
    void newCar(){
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("자동차 이름 Null이면 예외")
    void validateNull() {
        Car car = new Car(null);
        assertThat(car.getName()).isEqualTo(null);
    }

}
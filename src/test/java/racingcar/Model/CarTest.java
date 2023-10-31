package racingcar.Model;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 객체 생성 테스트")
    void CAR_객체_생성_테스트() {
        Car car = Car.from("kia");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("Car 객체의 Location 출력 테스트")
    void CAR_GET_LOCATION_테스트() {
        Car car = Car.from("kia");
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 객체의 Location 출력 실패 테스트")
    void CAR_GET_LOCATION_실패_테스트() {
        Car car = Car.from("kia");
        assertThat(car.getLocation()).isNotEqualTo(1);
    }

    @Test
    @DisplayName("Car 객체의 Name 출력 테스트")
    void CAR_GET_NAME_테스트() {
        Car car = Car.from("kia");
        assertThat(car.getName()).isEqualTo("kia");
    }

    @Test
    @DisplayName("Car 객체의 Name 출력 실패 테스트")
    void CAR_GET_NAME_실패_테스트() {
        Car car = Car.from("kia");
        assertThat(car.getName()).isNotEqualTo("kkia");
    }

    @Test
    @DisplayName("Car 객체 전진 테스트")
    void CAR_전진_성공() {
        Car car = Car.from("kia");
        car.goForward();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}
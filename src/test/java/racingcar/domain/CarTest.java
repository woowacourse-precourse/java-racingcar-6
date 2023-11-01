package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @Test
    @DisplayName("Car 생성 테스트 - 성공")
    public void create_car_test_success() {
        //given
        String name = "createCar";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo(name);

    }


    @Test
    @DisplayName("Car 이동 테스트 - 성공")
    public void moving_car_test_success() {
        //given
        Car car = new Car("movingCar");

        //when
        car.move();

        //then
        assertThat(car.getLocation()).isEqualTo(1);

    }

}
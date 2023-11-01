package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @Test
    void getName() {
        //given
        Car car = new Car("testCar");
        //when
        String carName = car.getName();
        //then
        assertThat(carName).isEqualTo("testCar");
    }

    @Test
    void getDistance() {
        //given
        Car car = new Car("testCar");
        //when
        int carDistance = car.getDistance();
        //then
        assertThat(carDistance).isEqualTo(0);
    }

    @Test
    void 차가_움직이면_distance_추가() {
        //given
        Car car = new Car("testCar");
        //when
        car.move();
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
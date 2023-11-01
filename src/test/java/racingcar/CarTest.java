package racingcar;

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
    void 랜덤숫자가_4미만이면_false() {
        //given
        Car car = new Car("testCar");
        //when
        boolean result = car.canMove(1);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void 랜덤숫자가_4이상이면_true() {
        //given
        Car car = new Car("testCar");
        //when
        boolean result = car.canMove(4);
        //then
        assertThat(result).isTrue();
    }
}
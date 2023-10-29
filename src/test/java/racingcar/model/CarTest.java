package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차위치_초기값0() {
        Car car = new Car("testCar");
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차전진_랜덤값4이상_테스트설정값4() {
        Car car = new Car("testCar");
        int randomNumber = 4;
        car.setPosition(randomNumber);

        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차전친_랜덤값4이상_테스트설정값9() {
        Car car = new Car("testCar");
        int randomNumber = 9;
        car.setPosition(randomNumber);

        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차전진_랜덤값4미만_테스트설정값1() {
        Car car = new Car("testCar");
        int randomNumber = 1;
        car.setPosition(randomNumber);

        assertThat(0).isEqualTo(car.getPosition());
    }
}
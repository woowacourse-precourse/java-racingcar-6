package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void runOrStop_랜덤값이_4미만이면_stop() {
        // given
        int randomValue = 3;
        Car car = new Car("testCar");
        int initCarCount = car.getCount();

        // when
        car.runOrStop(randomValue);

        // then
        assertThat(car.getCount()).isEqualTo(initCarCount);
    }

    @Test
    void runOrStop_랜덤값이_4이면_run() {
        //given
        int randomValue = 4;
        Car car = new Car("testCar");
        int initCarCount = car.getCount();

        //when
        car.runOrStop(randomValue);

        //then
        assertThat(car.getCount()).isGreaterThan(initCarCount);
    }

    @Test
    void runOrStop_랜덤값이_4이상이면_run() {
        //given
        int randomValue = 7;
        Car car = new Car("testCar");
        int initCarCount = car.getCount();

        //when
        car.runOrStop(randomValue);

        //then
        assertThat(car.getCount()).isGreaterThan(initCarCount);
    }
}
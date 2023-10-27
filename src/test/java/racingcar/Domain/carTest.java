package racingcar.Domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void car_객체_생성하기() {
        //given
        String name = "testCar";

        //when
        Car testInstance = Car.of(name);

        //then
        assertThat(testInstance).isNotNull();
    }

    @Test
    void car_이름_조회하기() {
        //given
        String name = "testCar";

        //when
        Car testInstance = Car.of(name);

        //then
        assertThat(testInstance.findName()).isEqualTo(name);
    }

    @Test
    void car_초기_위치_조회하기() {
        //given
        String name = "testCar";

        //when
        Car testInstance = Car.of(name);

        //then
        assertThat(testInstance.findPosition()).isEqualTo(0);
    }

    @Test
    void car_위치_수정하기() {
        //given
        String name = "testCar";

        //when
        Car testInstance = Car.of(name);
        testInstance.updatePosition();

        //then
        assertThat(testInstance.findPosition()).isEqualTo(1);
    }
}
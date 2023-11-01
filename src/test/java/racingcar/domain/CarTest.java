package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void power가_4이상일때_전진한다() {
        // given
        Car car = new Car("car");

        // when
        car.move(4);

        // then
        assertEquals(1, car.getPosition());
    }

    @Test
    void power가_3이하일때_멈춘다() {
        // given
        Car car = new Car("car");

        // when
        car.move(3);

        // then
        assertEquals(0, car.getPosition());
    }



}
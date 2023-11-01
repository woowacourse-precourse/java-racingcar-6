package racingcar.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void 차량_이름_테스트() {
        // given
        String expectedName = "테스트카";
        Car car = new Car(expectedName);

        // when
        String actualName = car.getName();

        // then
        assertEquals(expectedName, actualName);
    }

}
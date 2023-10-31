package racingcar.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStatusTest {

    @Test
    void 자동차_상태_생성_테스트() {
        // given
        Car car = new Car("pobi");

        // when
        CarStatus carStatus = CarStatus.of(car);

        // then
        assertEquals("pobi", carStatus.getName());
        assertEquals(0, carStatus.getMoveDistance());
    }

    @Test
    void 자동차_상태_문자열_변환_테스트() {
        // given
        Car car = new Car("pobi");
        car.proceed();
        car.proceed();

        // when
        CarStatus carStatus = CarStatus.of(car);

        // then
        assertEquals("pobi : --", carStatus.toString());
    }

}
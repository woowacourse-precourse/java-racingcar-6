package racingcar.entity;

import org.junit.jupiter.api.Test;
import racingcar.constants.Constants;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_객체_생성_테스트() {
        Car car = new Car("test");
        assertEquals("test", car.getName());
    }

    @Test
    void 자동차_이름_길이_유효성_테스트() {
        String longName = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> new Car(longName));
    }

    @Test
    void 자동차_이름_null_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 자동차_이름_빈문자열_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(Constants.MIN_MOVE_NUMBER.<Integer>getValue());
        assertEquals(initialPosition + 1, car.getPosition());
    }

    @Test
    void 자동차_정지_테스트() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(Constants.MIN_MOVE_NUMBER.<Integer>getValue() - 1);
        assertEquals(initialPosition, car.getPosition());
    }

}

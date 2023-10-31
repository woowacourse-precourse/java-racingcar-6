package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    CarName carName;
    Car car;

    @BeforeEach
    void init() {
        carName = new CarName("Test");
        car = new Car(carName);
    }

    @Test
    void 이름을_입력해_Car객체를_생성() {
        Assertions.assertNotNull(car);
    }

    @Test
    void 숫자4_이상_입력시_전진한다() {
        car.moveForward(4);
        assertEquals("Test : -", car.printCurrentStatus());
        assertEquals(1, car.getMoveCount());
    }

    @Test
    void 숫자4_미만_입력시_이동하지않는다() {
        car.moveForward(3);
        assertEquals("Test : ", car.printCurrentStatus());
        assertEquals(0, car.getMoveCount());
    }

    @Test
    void Car객체_생성시_진행그래프의_초기_상태를_만든다() {
        assertEquals("Test : ", car.printCurrentStatus());
    }

    @Test
    void Car객체_생성시_초기_MoveCount는_0이다() {
        assertEquals(0, car.getMoveCount());
    }

}
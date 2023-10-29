package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.RandomNumberGenerator;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private RandomNumberGenerator testRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        testRandomNumberGenerator = new TestRandomNumberGenerator(4);
    }

    @Test
    void 자동차_생성() {
        assertDoesNotThrow(() -> new Car("pobi", testRandomNumberGenerator));
    }

    @Test
    void 이름_길이_검증() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car("pobipobi", testRandomNumberGenerator));
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("pobi", testRandomNumberGenerator);
        car.move();
        assertEquals(1, car.toCarDto().getPosition());
    }

    @Test
    void 자동차_멈춤_테스트() {
        RandomNumberGenerator stopRandomNumberGenerator = new TestRandomNumberGenerator(3);
        Car car = new Car("pobi", stopRandomNumberGenerator);
        car.move();
        assertEquals(0, car.toCarDto().getPosition());
    }
}


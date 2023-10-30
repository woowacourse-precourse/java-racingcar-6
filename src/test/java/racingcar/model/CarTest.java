package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

class CarTest {

    @Test
    void 임의의_수가_4_이상일_경우_전진() {
        NumberGenerator testNumberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 4;
            }
        };

        Car car = new Car("test", testNumberGenerator);
        car.moveOrStay();

        assertEquals(car.getDistance(), 1L);
    }

    @Test
    void 임의의_수가_3_이하일_경우_정지() {
        NumberGenerator testNumberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 3;
            }
        };

        Car car = new Car("test", testNumberGenerator);
        car.moveOrStay();

        assertEquals(car.getDistance(), 0L);
    }
}
package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.CarDto;
import racingcar.domain.car.wrapper.Name;
import racingcar.domain.car.wrapper.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void move_후_toString_작동_테스트() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(() -> {
            Car car = new Car(new Name("test"));
            car.move();
            car.move();
            car.move();
            assertEquals(car.toString(), "test : --");
        }, 4, 3, 5);
    }

    @Test
    void compareTo_정상_작동_테스트() {
        Car c1 = new Car(new Name("test1"));
        Car c2 = new Car(new Name("test2"));
        assertEquals(c1.compareTo(c2), 0);

        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(c1::move, 4);
        assertEquals(c1.compareTo(c2), 1);
        assertEquals(c2.compareTo(c1), -1);
    }

    @Test
    void isSamePosition_정상_작동_테스트() {
        Car c1 = new Car(new Name("test1"));
        Car c2 = new Car(new Name("test2"));
        assertTrue(c1.isSamePosition(c1));
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(c1::move, 4);
        assertFalse(c1.isSamePosition(c2));
    }

    @Test
    void toCarDto_정상_작동_테스트() {
        Car car = new Car(new Name("test"));
        assertEquals(car.toCarDto(), new CarDto(new Name("test"), new Position()));

    }
}

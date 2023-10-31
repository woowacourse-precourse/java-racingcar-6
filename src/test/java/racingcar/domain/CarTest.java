package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.common.consts.SystemConst;


class CarTest {

    @Test
    void DTO_정상적으로_생성한다() {
        String name = "test";
        Car car = new Car(name, SystemConst.INITIAL_ADVANCE);
        CarDto carDto = car.toDto();
        assertEquals(name, carDto.getName());
    }

    @Test
    void Car를_움직인다() {
        Car car = new Car("test", SystemConst.INITIAL_ADVANCE);
        car.move();
        assertEquals(SystemConst.ADVANCE_STEP, car.toDto().getAdvance());
    }

    @Test
    void compareTo에서_advance가_같으면_0이_반환한다() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        assertEquals(0, car1.compareTo(car2));
    }

    @Test
    void compareTo에서_advance가_크면_음수가_반환된다() {
        Car car1 = new Car("test1", 2);
        Car car2 = new Car("test2", 1);
        assertEquals(-1, car1.compareTo(car2));
    }

    @Test
    void compareTo에서_advance가_작으면_양수가_반환된다() {
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        assertEquals(1, car1.compareTo(car2));
    }

    @Test
    void testToString() {
        Car car = new Car("test1", 1);
        String str = "test1 : -";
        assertEquals(str, car.toString());
    }
}
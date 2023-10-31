package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import racingcar.common.consts.SystemConst;
import racingcar.common.utils.NumberGenerator;

@TestInstance(Lifecycle.PER_CLASS)
class CarTest {

    @BeforeAll
    public void setup() {
        mockStatic(NumberGenerator.class);
    }

    @Test
    void DTO_정상적으로_생성한다() {
        String name = "test";
        Car car = new Car(name, SystemConst.INITIAL_ADVANCE);
        CarDto carDto = car.toDto();
        assertEquals(name, carDto.getName());
    }

    @Test
    void RandomNumber가_MOVE_FORMARD보다_크면_움직인다() {
        int randomNumber = SystemConst.MOVE_FORWARD_NUMBER;
        when(NumberGenerator.makeRandomNumber()).thenReturn(randomNumber);
        Car car = new Car("test", SystemConst.INITIAL_ADVANCE);
        car.move();
        assertEquals(SystemConst.ADVANCE_STEP, car.toDto().getAdvance());
    }

    @Test
    void RandomNumber가_MOVE_FORMARD보다_작으면_움직인다() {
        int randomNumber = SystemConst.MOVE_FORWARD_NUMBER - 1;
        when(NumberGenerator.makeRandomNumber()).thenReturn(randomNumber);
        Car car = new Car("test", SystemConst.INITIAL_ADVANCE);
        car.move();
        assertEquals(SystemConst.INITIAL_ADVANCE, car.toDto().getAdvance());
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
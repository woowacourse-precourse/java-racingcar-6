package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    @Test
    public void 전진_가능_테스트() throws Exception {
        //given
        NumberGenerator generator = new StubNumberGenerator(5);
        Car car = new Car("minju", generator);
        int expected = 1;

        //when
        car.move();

        //then
        assertTrue(car.getPosition() == expected);
    }

    @Test
    public void 전진_불가능_테스트() throws Exception {
        //given
        NumberGenerator generator = new StubNumberGenerator(3);
        Car car = new Car("minju", generator);
        int expected = 0;

        //when
        car.move();

        //then
        assertTrue(car.getPosition() == expected);
    }

    @Test
    public void 자동차_이름_부여_테스트() throws Exception {
        //given
        NumberGenerator generator = new StubNumberGenerator(3);
        Car car = new Car("minju", generator);
        String expected = "minju";

        //when
        String actual = car.getName();

        //then
        assertTrue(expected.equals(actual));
    }
}
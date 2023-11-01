package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    @Test
    public void 전진_가능_테스트() throws Exception {
        //given
        NumberGenerator alwaysMoveGenerator = new StubNumberGenerator(5);
        Car car = new Car("pobi", alwaysMoveGenerator);
        int expectedPosition = 1;

        //when
        car.move();
        int actualPosition = car.getPosition();

        //then
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void 전진_불가능_테스트() throws Exception {
        //given
        NumberGenerator neverMoveGenerator = new StubNumberGenerator(3);
        Car car = new Car("pobi", neverMoveGenerator);
        int expectedPosition = 0;

        //when
        car.move();
        int actualPosition = car.getPosition();

        //then
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void 자동차_이름_부여_테스트() throws Exception {
        //given
        NumberGenerator generator = new StubNumberGenerator(3);
        Car car = new Car("pobi", generator);
        String expectedName = "pobi";

        //when
        String actualName = car.getName();

        //then
        assertEquals(expectedName, actualName);
    }
}
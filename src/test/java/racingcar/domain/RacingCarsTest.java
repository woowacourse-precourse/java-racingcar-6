package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.consts.SystemConst;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setup() {
        racingCars = new RacingCars();
    }

    @Test
    void 공동_우승자_생성한다() {
        Car car1 = new Car("test1", 5);
        Car car2 = new Car("test2", 5);

        racingCars.add(car1);
        racingCars.add(car2);

        RacingCarsResult racingCarsResult = racingCars.getRacingCarsResult();
        assertEquals(2, racingCarsResult.size());
        assertEquals("test1,test2", racingCarsResult.toString());
    }

    @Test
    void 단독_우승자_생성한다() {
        Car car1 = new Car("test1", 6);
        Car car2 = new Car("test2", 5);

        racingCars.add(car1);
        racingCars.add(car2);

        RacingCarsResult racingCarsResult = racingCars.getRacingCarsResult();
        assertEquals(1, racingCarsResult.size());
        assertEquals("test1", racingCarsResult.toString());
    }

    @Test
    void racingCars에_add를_통해_값을_집어넣고_size를_체크한다() {
        Car car1 = new Car("test1", 6);
        Car car2 = new Car("test2", 5);

        racingCars.add(car1);
        racingCars.add(car2);

        assertEquals(2, racingCars.size());
    }

    @Test
    void List안에_Car객체들을_이동시킨다() {
        Car car1 = new Car("test1", 5);

        racingCars.add(car1);

        racingCars.moveCar();

        assertEquals(6, car1.toDto().getAdvance());
    }

    @Test
    void RacingCars의_toString이_정상적으로_작동한다() {
        Car car1 = new Car("test1", 6);
        Car car2 = new Car("test2", 5);

        racingCars.add(car1);
        racingCars.add(car2);

        String str = car1.toString() + SystemConst.LINE_SEPARATOR + car2.toString() + SystemConst.LINE_SEPARATOR;
        assertEquals(str, racingCars.toString());
    }
}
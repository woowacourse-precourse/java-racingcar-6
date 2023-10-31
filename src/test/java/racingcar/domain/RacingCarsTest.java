package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import racingcar.common.consts.SystemConst;

@TestInstance(Lifecycle.PER_CLASS)
class RacingCarsTest {
    private RacingCars racingCars;
    private MockRandomNumberGenerator mockNumberGenerator;

    @BeforeEach
    void setup() {
        mockNumberGenerator = new MockRandomNumberGenerator(List.of(3, 4, 3, 4));
        racingCars = new RacingCars(mockNumberGenerator);
    }

    @Test
    void Car_객체를_생성합니다() {
        racingCars.generateCar("test");
        assertEquals(1, racingCars.size());
    }

    @Test
    void String_배열을_통해_Car를_여러개_생성합니다() {
        racingCars.generateCars("test1,test2,test3");
        assertEquals(3, racingCars.size());
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
    void List안에_Car객체들을_RandomNumber에_따라_움직인다() {
        Car car1 = new Car("test1", 5);
        Car car2 = new Car("test2", 5);
        Car car3 = new Car("test3", 5);
        Car car4 = new Car("test4", 5);

        racingCars.add(car1);
        racingCars.add(car2);
        racingCars.add(car3);
        racingCars.add(car4);

        racingCars.moveRacingCars();

        assertEquals(5, car1.toDto().getAdvance());
        assertEquals(6, car2.toDto().getAdvance());
        assertEquals(5, car3.toDto().getAdvance());
        assertEquals(6, car4.toDto().getAdvance());
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
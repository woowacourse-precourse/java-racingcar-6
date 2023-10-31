package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import racingcar.common.consts.SystemConst;
import racingcar.common.utils.NumberGenerator;

@TestInstance(Lifecycle.PER_CLASS)
class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeAll
    void setupStaticClass() {
        mockStatic(NumberGenerator.class);
    }

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
    void List안에_Car객체들을_RandomNumber가_MOVE_FORMARD보다_크면_움직인다() {
        int randomNumber = SystemConst.MOVE_FORWARD_NUMBER;
        when(NumberGenerator.makeRandomNumber()).thenReturn(randomNumber);
        Car car1 = new Car("test1", 5);

        racingCars.add(car1);

        racingCars.moveRacingCars();

        assertEquals(6, car1.toDto().getAdvance());
    }

    @Test
    void List안에_Car객체들을_RandomNumber가_MOVE_FORMARD보다_작으면_안움직인다() {
        int randomNumber = SystemConst.MOVE_FORWARD_NUMBER - 1;
        when(NumberGenerator.makeRandomNumber()).thenReturn(randomNumber);
        Car car1 = new Car("test1", 5);

        racingCars.add(car1);

        racingCars.moveRacingCars();

        assertEquals(5, car1.toDto().getAdvance());
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
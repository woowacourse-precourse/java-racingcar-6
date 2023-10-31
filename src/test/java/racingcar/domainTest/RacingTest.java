package racingcar.domainTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {
    private Race race;

    @BeforeEach
    void setup() {
        race = new Race();
    }

    @Test
    void 이동_횟수만큼_경주_진행() {
        List<Car> cars = new ArrayList<>();
        int moveCount = 5;

        cars.add(new Car("tayo"));

        int actualCount = 0;
        for (int i = 0; i < moveCount; i++) {
            race.moveCars(cars);
            actualCount++;
        }

        int expectedCount = moveCount;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void 랜덤번호가_4_이상인_경우_전진() {
        Car car = new Car("tayo");
        car.move(4);
        assertEquals("-", car.getStatus());
    }
}
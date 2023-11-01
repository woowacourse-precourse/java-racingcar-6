package racingcar.domain.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.collection.Cars;
import racingcar.domain.car.wrapper.Name;
import racingcar.domain.race.wrapper.Count;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {

    private Cars cars;
    private Count count;
    private Race race;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(new Name("test1"), new Name("test2")));
        count = new Count("3");
        race = new Race(cars, count);
    }

    @Test
    void runOneCycle_후_isOver_정상_작동_확인() {
        assertFalse(race.isOver());

        race.runOneCycle();
        race.runOneCycle();
        race.runOneCycle();

        assertTrue(race.isOver());
    }
}

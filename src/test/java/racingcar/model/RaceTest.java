package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RaceTest extends NsTest {

    List<Car> cars;
    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
    }

    @Test
    void 게임_내_자동차_수_확인() {
        Race race = new Race(cars, 3);
        assertEquals(race.getCars().size(), 3);
    }

    @Test
    void 게임_내_자동차_이름_확인() {
        Race race = new Race(cars, 3);
        assertEquals(race.getCars().get(0).getName(), "a");
        assertEquals(race.getCars().get(1).getName(), "b");
        assertEquals(race.getCars().get(2).getName(), "c");
    }

    @Test
    void 게임_횟수_증가() {
        Race race = new Race(cars, 3);
        assertEquals(race.checkGamesExhausted(), false);
        for (int i = 0; i < 3; i ++) {
            race.increaseGameOrder();
        }
        assertEquals(race.checkGamesExhausted(), true);
    }

    @Override
    protected void runMain() {
    }
}

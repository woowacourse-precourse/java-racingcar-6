package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.CarsFixture;
import racingcar.application.RandomMoveRule;
import racingcar.domain.car.Cars;
import racingcar.domain.policy.MoveRule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RaceTest {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("경주는 정상적으로 진행되어야 한다. 모두 진행")
    void 경주는_정상적으로_진행_모두_진행() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(4);

        Cars cars = CarsFixture.fixture().build();

        Race race = new Race(moveRule);

        race.run(cars);

        assertEquals("""
                First : -
                Secon : -
                Third : -
                """, cars.printPosition());
    }

    @Test
    @DisplayName("경주는 정상적으로 진행되어야 한다. 2개만 진행")
    void 경주는_정상적으로_진행_2개만_진행() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(4, 4, 2);

        Cars cars = CarsFixture.fixture().build();

        Race race = new Race(moveRule);

        race.run(cars);

        assertEquals("""
                First : -
                Secon : -
                Third :\s
                """, cars.printPosition());
    }

    @Test
    @DisplayName("경주는 정상적으로 진행되어야 한다. 1개만 진행")
    void 경주는_정상적으로_진행_1개만_진행() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(2, 4, 2);

        Cars cars = CarsFixture.fixture().build();

        Race race = new Race(moveRule);

        race.run(cars);

        assertEquals("""
                First :\s
                Secon : -
                Third :\s
                """, cars.printPosition());
    }

    @Test
    @DisplayName("경주는 정상적으로 진행되어야 한다. 진행 못함")
    void 경주는_정상적으로_진행_진행_못함() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(2, 2, 2);

        Cars cars = CarsFixture.fixture().build();

        Race race = new Race(moveRule);

        race.run(cars);

        assertEquals("""
                First :\s
                Secon :\s
                Third :\s
                """, cars.printPosition());
    }
}
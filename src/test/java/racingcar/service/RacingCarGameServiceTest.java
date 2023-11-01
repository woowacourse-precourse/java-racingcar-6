package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class RacingCarGameServiceTest {

    @Test
    public void calculateMaxDistance_ifListIsEmpty() {
        // when
        List<RacingCar> racingCars = new ArrayList<>();

        // when
        int result = RacingCarGameService.calculateMaxDistance(racingCars);

        // then
        assertEquals(result, 0);
    }

    @Test
    public void calculateMaxDistance_test() {
        // when
        RacingCar racingCar1 = buildRacingCar("test1", 1);
        RacingCar racingCar2 = buildRacingCar("test2", 2);
        RacingCar racingCar3 = buildRacingCar("test3", 3);
        List<RacingCar> racingCars = Lists.newArrayList(racingCar1, racingCar2, racingCar3);

        // when
        int result = RacingCarGameService.calculateMaxDistance(racingCars);

        // then
        assertEquals(result, 3);
    }

    @Test
    public void calculateWinner_oneWinner() {
        // when
        RacingCar racingCar1 = buildRacingCar("test1", 1);
        RacingCar racingCar2 = buildRacingCar("test2", 2);
        RacingCar racingCar3 = buildRacingCar("test3", 3);
        List<RacingCar> racingCars = Lists.newArrayList(racingCar1, racingCar2, racingCar3);

        // when
        List<RacingCar> result = RacingCarGameService.calculateWinner(racingCars);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getName(), "test3");
        assertEquals(result.get(0).getAdvanceDistance(), 3);
    }

    @Test
    public void calculateWinner_multipleWinner() {
        // when
        RacingCar racingCar1 = buildRacingCar("test1", 1);
        RacingCar racingCar2 = buildRacingCar("test2", 3);
        RacingCar racingCar3 = buildRacingCar("test3", 3);
        List<RacingCar> racingCars = Lists.newArrayList(racingCar1, racingCar2, racingCar3);

        // when
        List<RacingCar> result = RacingCarGameService.calculateWinner(racingCars);

        // then
        assertEquals(result.size(), 2);
    }

    private RacingCar buildRacingCar(String name, int advanceNumber) {
        RacingCar racingCar = new RacingCar(name);
        while(advanceNumber-- > 0) {
            racingCar.advanceByNumber(4);
        }
        return racingCar;
    }
}
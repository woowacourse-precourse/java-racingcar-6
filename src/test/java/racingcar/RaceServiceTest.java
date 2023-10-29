package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = RaceService.getInstance();
    }

    @AfterEach
    void tearDown() {
        raceService = null;
    }

    @Test
    @DisplayName("입력문자열을 검증하고, 입력으부터 자동차들을 생성합니다.")
    void getCarsFromInput() {
        // GIVEN
        String raceCarNames = "pobi,woni,jun";

        // WHEN
        List<Car> cars = raceService.getCarsFromInput(raceCarNames);

        // THEN
        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
        assertEquals("jun", cars.get(2).getName());

    }

    @Test
    @DisplayName("입력문자열을 검증하고, 입력으부터 시도횟수를 생성합니다.")
    void getRoundFromInput() {
        // GIVEN
        String roundInput = "3";
        int expectedRound = 3;

        // WHEN
        int round = raceService.getRoundFromInput(roundInput);

        // THEN
        assertEquals(expectedRound, round);
    }
}